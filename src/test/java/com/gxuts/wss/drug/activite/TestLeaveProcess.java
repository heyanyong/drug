package com.gxuts.wss.drug.activite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.transformer.Identity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
//@Transactional
//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestLeaveProcess {
	@Autowired
	public IdentityService identityService;
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Test//7501-出库流程-部署完成
	public void testDeploy(){
		String fileName="leave";
		String deployName="请假流程";
		Deployment deploy=repositoryService.createDeployment()//
				.addClasspathResource("process/"+fileName+".bpmn")//
				.addClasspathResource("process/"+fileName+".png")//
				.name(deployName)
				.deploy();
		System.out.println(deploy.getId()+"-"+deploy.getName()+"-部署完成");
	}

 
	@Test//15001
	public void testStart(){
		String processDefinitionKey="leave";
		String businessKey="请假流程";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("creater", "admin");
		variables.put("departmentId", 10);
		variables.put("billId", 1);
		variables.put("outcome", 1);
		variables.put("roleGrade", 500);
		variables.put("mapping", "leave");
		variables.put("assignee", "assignee1");
//		List<String> assigneeList=null;
		variables.put("assigneeList", Arrays.asList("r3","r2","r1"));
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey,variables);
		System.out.println("实例ID："+processInstance.getId()); //
	}

	@Test
	public void complete(){
		String taskId = "30013";
//		String processInstanceId = "177501";
//		taskService.addComment(taskId, processInstanceId, "提交");
		taskService.complete(taskId);
		
	}
	
	
	
	@Test
	public void test(){
		String processInstanceId = "2501";
		List<IdentityLink> identityList =runtimeService.getIdentityLinksForProcessInstance(processInstanceId);
		for (IdentityLink vo:identityList) {
			System.out.println(vo);
		}
	}
	/*
	 * 2501
		张三的出库申请:leaveDetail:1001*/
	@Test
	public void testTask(){
		String assignee="NF0005";
		List<Task> taskList=taskService.createTaskQuery().taskAssignee(assignee).list();
		for(Task task:taskList){
			System.out.println(task.getAssignee());
			System.out.println(task.getId());
			System.out.println(task.getName());
			System.out.println(task.getProcessInstanceId());
			ProcessInstance pi= runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
			System.out.println(pi.getBusinessKey());
		}
	}
	@Test
	public void getCurrent(){
		ProcessInstance pi=runtimeService.createProcessInstanceQuery().active().list().get(0);
		String a=pi.getActivityId();
		System.out.println(a);
	}
}
