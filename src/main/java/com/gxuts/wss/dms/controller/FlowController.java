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
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.hr.UserInfo;
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
	private HistoryService historyService;
	
	
	@RequestMapping(value="start")
	public void  start(){
		String processDefinitionKey="export";
		String businessKey="NF0001张三的出库申请2:leaveDetail:1001";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("createUser", "NF0002");
		List<String> assigneeList=Arrays.asList("liyagn","cooperay","other");
		variables.put("assigneeList", assigneeList);
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey,variables);
		System.out.println(processInstance.getId()); //
		System.out.println(processInstance.getBusinessKey());//
		Map<String, Object> vars2=processInstance.getProcessVariables();
		for(Object o:vars2.values()){
			System.out.println("*"+o);
		}
	}
	
	@RequestMapping(value="/complete/{taskId}")
	public void complete(@PathVariable String taskId){
		taskService.complete(taskId);
		
	}
	@RequestMapping(value="/taskList")
	public String taskList(Model m,HttpSession session,String  pageNum){
		pageNum=pageNum==null? "1":pageNum;
		UserInfo user=(UserInfo) session.getAttribute("loginUser");
		Page<Object[]> page=flowService.queryPersonTask(user.getNo(), Integer.parseInt(pageNum), 10);
//		Json j=new Json();
		m.addAttribute("taskList", page.getData());
		return "taskCenter";
	}
	
	/**
	 * 查看流程图
	 * @throws Exception 
	 */
	@RequestMapping(value="/img")
	public String viewImage(String deploymentId,String imageName,HttpServletResponse response) throws Exception{
		//1：获取页面传递的部署对象ID和资源图片名称
		//部署对象ID
		//String deploymentId = workflowBean.getDeploymentId();
		//资源图片名称
		//String imageName = workflowBean.getImageName();
		//2：获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
		InputStream in = repositoryService.getResourceAsStream(deploymentId,imageName);
		//3：从response对象获取输出流
		OutputStream out = response.getOutputStream();
		//4：将输入流中的数据读取出来，写到输出流中
		for(int b=-1;(b=in.read())!=-1;){
			out.write(b);
		}
		out.close();
		in.close();
		//将图写到页面上，用输出流写
		return null;
	}
	@RequestMapping(value="/currentImage")
	public String viewCurrentImage(HttpServletRequest req){
		//任务ID
		String taskId = "60004";
		String processDefinitionId="leave:3:27504";
		/**一：查看流程图*/
		//1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()//创建流程定义查询对象，对应表act_re_procdef 
				.processDefinitionId(processDefinitionId)//使用流程定义ID查询
				.singleResult();
		//workflowAction_viewImage?deploymentId=<s:property value='#deploymentId'/>&imageName=<s:property value='#imageName'/>
		req.setAttribute("deploymentId", pd.getDeploymentId());
		req.setAttribute("imageName", pd.getDiagramResourceName());
		//ValueContext.putValueContext("deploymentId", pd.getDeploymentId());
		//ValueContext.putValueContext("imageName", pd.getDiagramResourceName());
		/**二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中*/
		Map<String, Object> map = findCoordingByTask(taskId);
		req.setAttribute("acs", map);
		return "flowImg";
	}
	
	public Map<String, Object> findCoordingByTask(String taskId) {
		//存放坐标
		Map<String, Object> map = new HashMap<String,Object>();
		//使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()//
					.taskId(taskId)//使用任务ID查询
					.singleResult();
		//获取流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();
		//获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processDefinitionId);
		//流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		//使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//创建流程实例查询
					.processInstanceId(processInstanceId)//使用流程实例ID查询
					.singleResult();
		//获取当前活动的ID
		String activityId = pi.getActivityId();
		//获取当前活动对象
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//活动ID
		//获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
		return map;
	}
}
