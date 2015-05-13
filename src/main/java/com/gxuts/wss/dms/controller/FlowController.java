package com.gxuts.wss.dms.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.xmlbeans.impl.jam.mutable.MElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
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
	
	
	
	@RequestMapping(value="/complete")
	@ResponseBody
	public Json completeByDeal(String taskId,String processInstanceId, int outcome, String comment){
		String userNo=flowService.dealTask(taskId, processInstanceId, outcome, comment);
		String msg=userNo.length()<3? "流程结束":"任务到达:"+userNo+"办理";
		return new Json(msg,"200","leaveList","leaveList","closeCurrent","leave/list");
		
	}
	@RequestMapping(value="/transfer")
	@ResponseBody
	public Json transfer(String taskId,String assignee){
		flowService.transfer(taskId,assignee);
		String msg= "任务到达:"+assignee+"办理";
		return new Json(msg,"200","leaveList","leaveList","closeCurrent","leave/list");
		
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
		Page<Object[]> page=flowService.queryPersonTask(user.getName()+"("+user.getNo()+")", Integer.parseInt(pageNum), 2);
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
		return "flowDeployList";
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
			current="流程已结束";
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
			String startTime,String endTime,String  pageNum){
		StringBuilder bk=new StringBuilder();
		if(dept!=null&&!"".equals(dept)){
			bk.append(dept+"#");
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
		
		Page<Object[]> ins=flowService.instanceList(bk.toString(),startTime,endTime,Integer.parseInt(pageNum));
		return "instanceList";
	}
	 
}
