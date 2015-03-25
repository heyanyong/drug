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
import org.apache.xmlbeans.impl.jam.mutable.MElement;
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
	
	
	
	@RequestMapping(value="/complete")
	@ResponseBody
	public Json completeByDeal(String taskId,String processInstanceId, int outcome, String comment){
		String userNo=flowService.dealTask(taskId, processInstanceId, outcome, comment);
		String msg=userNo==null? "任务结束":"任务到达:"+userNo+"办理";
		return new Json(msg,"200","leaveList","leaveList","closeCurrent","leave/list");
		
	}
	@RequestMapping(value="/transfer")
	@ResponseBody
	public Json transfer(String taskId,String assignee){
		flowService.transfer(taskId,assignee);
		String msg= "任务到达:"+assignee+"办理";
		return new Json(msg,"200","leaveList","leaveList","closeCurrent","leave/list");
		
	}
	 
	@RequestMapping(value="/taskList")
	public String taskList(Model m,HttpSession session,String  pageNum){
		pageNum=pageNum==null? "0":pageNum;
		UserInfo user=(UserInfo) session.getAttribute("loginUser");
		Page<Object[]> page=flowService.queryPersonTask(user.getNo(), Integer.parseInt(pageNum), 2);
		m.addAttribute("taskPage", page);
		return "taskCenter";
	}
	@RequestMapping(value="/historyTaskList")
	public String historyTaskList(Model m,HttpSession session,String  pageNum){
		pageNum=pageNum==null? "0":pageNum;
		UserInfo user=(UserInfo) session.getAttribute("loginUser");
		Page<Object[]> page=flowService.queryPersonTaskHistory(user.getNo(), Integer.parseInt(pageNum), 10);
		m.addAttribute("taskList", page.getData());
		return "taskCenter";
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
		List<Task> tasks= taskService.createTaskQuery().processInstanceId(flowId).active().list();
		String current = "";
		for(Task t:tasks){
			current+=t.getName()+":"+t.getAssignee()+" ";
		}
		m.addAttribute("current", current);
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
	 
}
