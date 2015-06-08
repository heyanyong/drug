package com.gxuts.wss.dms.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.AttaFile;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowService;
@Controller
@RequestMapping(value="/flow")
public class FlowController {
	@Autowired
	private FlowService flowService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(value="/complete")
	@ResponseBody
	public Json completeByDeal(String taskId,String processInstanceId, int outcome, String comment){
		String userNo=flowService.dealTask(taskId, processInstanceId, outcome, comment);
		String msg=userNo.length()<3? "流程结束":"任务到达:"+userNo+"办理";
		
		return new Json(msg,"200", "leaveList", "leaveList", "forward", "leave/list");
		
	}
	@RequestMapping(value="/transfer")
	@ResponseBody
	public Json transfer(String taskId,Integer assigneeId){
		UserInfo user=userService.get(UserInfo.class, assigneeId);
		String assignee=user.getName()+"("+user.getNo()+")";
		flowService.transfer(taskId,assignee);
		return new Json("任务到达:"+assignee+"办理","200","leaveList","leaveList","closeCurrent","leave/list");
		
	}
	@RequestMapping(value="/recall")
	@ResponseBody
	public Json recall(String instanceId,String reason){
		try {
			flowService.recall(instanceId, reason);
		} catch (Exception e) {
			return new Json("任务无法撤消","300","leaveList","leaveList","closeCurrent","leave/list");
		}
		return new Json("任务成功撤消","200","leaveList","leaveList","closeCurrent","leave/list");
	}
	 
	@RequestMapping(value="/taskList")
	public String taskList(Model m,HttpSession session,String  pageNum){
		pageNum=pageNum==null? "0":pageNum;
		UserInfo user=(UserInfo) session.getAttribute("loginUser");
		Page<Object[]> page=flowService.queryPersonTask(user.getName()+"("+user.getNo()+")", Integer.parseInt(pageNum), 10);
		m.addAttribute("taskPage", page);
		return "taskCenter";
	}
	@RequestMapping(value="/historyTaskList")
	public String historyTaskList(Model m,HttpSession session,String  pageNum){
		pageNum=pageNum==null? "0":pageNum;
		UserInfo user=(UserInfo) session.getAttribute("loginUser");
		Page<Object[]> page=flowService.queryPersonTaskHistory(user.getName()+"("+user.getNo()+")", Integer.parseInt(pageNum), 10);
		m.addAttribute("taskPage", page);
		return "taskCenter";
	}
	
	@RequestMapping(value="deployList")
	public String flowDeployList(Integer pageNum,Model m){
		pageNum=pageNum==null? 0 :pageNum;
		List<Deployment> deploys=repositoryService.createDeploymentQuery().orderByDeploymenTime().desc().listPage(pageNum, 1);
		Page<Deployment> pages=new Page<Deployment>(deploys, pageNum, 1, deploys.size());
		m.addAttribute("pages", pages);
		return "sys/deployList";
	}
	@RequestMapping(value="flowList")
	public String flowList(Integer pageNum,Model m){
		pageNum=pageNum==null? 0 :pageNum;
		List<ProcessDefinition> flows=repositoryService.createProcessDefinitionQuery().orderByDeploymentId().desc().orderByProcessDefinitionVersion().desc()
				.listPage(pageNum, 2);
		Page<ProcessDefinition> pages=new Page<ProcessDefinition>(flows, pageNum, 1, flows.size());
		m.addAttribute("pages", pages);
		return "flowList";
	}
	@RequestMapping(value="/track/{flowId}")
	public String track(@PathVariable String flowId ,Model m){
		String current = "";
		List<Task> tasks= taskService.createTaskQuery().processInstanceId(flowId).active().list();
		if(tasks==null||tasks.size()==0){
			current="流程已结束或撤销";
		}else{
			for(Task t:tasks){
				current+=t.getName()+":"+t.getAssignee()+" <br />";
			}
		}
		m.addAttribute("current", current);
		m.addAttribute("flowId", flowId);
		return "flowTrack";
	}
	
	/**
	 * 查看流程图
	 * @throws Exception 
	 */
	@RequestMapping(value="/image/{flowId}")
	public String viewDeal(@PathVariable String flowId ,Model m){
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(flowId).singleResult();
		if(pi==null){
			m.addAttribute("isEnd",true);
			return "flowImg";
		}
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionId(pi.getProcessDefinitionId()).singleResult();
		m.addAttribute("deploymentId", pd.getDeploymentId());
		m.addAttribute("imageName", pd.getDiagramResourceName());
		String activityId = pi.getActivityId();
		// 获取当前活动对象
		if(activityId!=null){
			Map<String, Object> map = new HashMap<String, Object>();
			ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
					.getProcessDefinition(pd.getId());
			ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);// 活动ID
			map.put("x", activityImpl.getX());
			map.put("y", activityImpl.getY());
			map.put("width", activityImpl.getWidth());
			map.put("height", activityImpl.getHeight());
			m.addAttribute("acs", map);
		}
		return "flowImg";
	}
	
	@RequestMapping(value="/img")
	public String viewImage(String deploymentId,String imageName,HttpServletResponse response) throws Exception{
		InputStream in = repositoryService.getResourceAsStream(deploymentId,imageName);
		OutputStream out = response.getOutputStream();
		for(int b=-1;(b=in.read())!=-1;){
			out.write(b);
		}
		out.close();
		in.close();
		return null;
	}
	@RequestMapping(value="instanceList")
	public String instanceList(String dept,String userName,String userNo,String title,
			String startTime,String endTime,String  pageNum,Model m){
		StringBuilder bk=new StringBuilder();
		if(dept!=null&&!"".equals(dept)){
			bk.append(dept+"%#");
		}
		if(userName!=null&&!"".equals(userName)){
			bk.append(userName);
		}else{
			bk.append("%");
		}
		if(userNo!=null&&!"".equals(userNo)){
			bk.append("("+userNo+")#");
		}else{
			bk.append("%");
		}
		if(title!=null&&!"".equals(title)){
			bk.append(title+"#");
		}
		pageNum=pageNum==null? "0":pageNum;
		
		Page<Object[]> ins=flowService.instanceList(bk.toString(),startTime,endTime,0,10);
		m.addAttribute("page", ins);
		return "instanceList";
	}
	
	@RequestMapping(value="deploy",method=RequestMethod.POST)
	@ResponseBody
	public Json deployByZIP(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,HttpSession session) throws IOException {
		if (!file.isEmpty()) {
			String userNo=((UserInfo)session.getAttribute("loginUser")).getNo();
			String savePath = session.getServletContext().getRealPath("/files/"+userNo+System.currentTimeMillis()+"/");
			String filename = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			File zipFile=new File(savePath,filename);
			FileUtils.writeByteArrayToFile(zipFile, bytes);
			flowService.deployByZIP(zipFile, name);
			System.out.println("上传成功");
			return new Json("部署成功","200","deployList","deployList","closeCurrent",null);
		}
		return new Json("部署失败","300");
	}
}