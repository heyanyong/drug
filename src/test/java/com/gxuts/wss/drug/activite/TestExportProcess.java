package com.gxuts.wss.drug.activite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TestExportProcess {
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
	@Test//1-出库流程-部署完成
	public void testDeploy(){
		String fileName="export";
		String deployName="出库流程";
		Deployment deploy=repositoryService.createDeployment()//
				.addClasspathResource("process/"+fileName+".bpmn")//
				.addClasspathResource("process/"+fileName+".png")//
				.name(deployName)
				.deploy();
		System.out.println(deploy.getId()+"-"+deploy.getName()+"-部署完成");
	}

	/**
	 * 2501
		张三的出库申请:leaveDetail:1001
	 */
	@Test
	public void testStart(){
		String processDefinitionKey="export";
		String businessKey="张三的出库申请:leaveDetail:1001";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("createUser", "NF0001");
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey,variables);
		System.out.println(processInstance.getId()); //
		System.out.println(processInstance.getBusinessKey());//
	}
	/*
	 * NF0001
2505
提交人
2501
张三的出库申请:leaveDetail:1001*/
	@Test
	public void testTask(){
		String assignee="NF0001";
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
	public void complete(){
		String taskId = "5016";
		String processInstanceId = "2501";
		Map<String,Object> variables=new HashMap<String, Object>();
		List<String> ckadmin=new ArrayList<String>();
		ckadmin.add("ck001");
		ckadmin.add("ck002");
		variables.put("ckadmin", ckadmin);
		taskService.addComment(taskId, processInstanceId, "ck 5013 好");
		taskService.complete(taskId,variables);
	}
	@Test
	public void test(){
		String processInstanceId = "2501";
		List<IdentityLink> identityList =runtimeService.getIdentityLinksForProcessInstance(processInstanceId);
		for (IdentityLink vo:identityList) {
			System.out.println(vo);
		}
	}
}
