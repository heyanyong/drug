package com.gxuts.wss.drug.activite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class HellowordProcess {
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	
	@Test
	public void testDeploy(){
		Deployment deploy=repositoryService.createDeployment()//
		.addClasspathResource("process/leave.bpmn")//
		.addClasspathResource("process/leave.png")//
		.name("deployLeave")
		.deploy();
		System.out.println("部署流程ID："+deploy.getId());
		System.out.println("部署流程名称："+deploy.getName());
		System.out.println(deploy.getCategory());
		System.out.println(deploy.getTenantId());
	}
	//10001
	@Test
	public void testStart(){
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("leave");
		System.out.println("启动ID："+processInstance.getId());
		System.out.println("启动名称："+processInstance.getName());
		System.out.println(processInstance.getProcessDefinitionVersion());
		
	}
	@Test
	public void testTask(){
		String assignee="张三";
		List<Task> taskList=taskService.createTaskQuery().taskAssignee(assignee).active().list();
		for(Task t:taskList){
			System.out.println(t.getAssignee());
			System.out.println(t.getId());
			System.out.println(t.getName());
			System.out.println("----------");  
		}
	}
	@Test
	public void testComplete(){
		String taskId="7504";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("message", "不同意");
		taskService.complete(taskId, variables);
		System.out.println("完成");
		
	}
	//7501 10001
	@Test
	public void testCurrent(){
		ProcessInstance pi= runtimeService.createProcessInstanceQuery().processInstanceId("7501").singleResult();
		System.out.println(pi.getActivityId());
	}
	
	
}
