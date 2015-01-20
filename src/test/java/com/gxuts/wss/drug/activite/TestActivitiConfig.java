package com.gxuts.wss.drug.activite;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.task.Task;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TestActivitiConfig {
	@Autowired
	private ProcessEngineFactoryBean processEngine;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Test
	public void testGetEngin() {
		System.out.println(repositoryService);
	}

	@Test
	public void testExport() {
		Deployment deploy = repositoryService.createDeployment() //
							.addClasspathResource("process/export.bpmn")//
							.name("出库流程")//
							.deploy();
		// select * from ACT_GE_PROPERTY;这时这个表中会多条数据
		runtimeService.startProcessInstanceByKey("export");// 启动流程，ID必须与你配置的一致
		System.out.println("流程部署完成");
	}
    //查个人任务列表
	@Test
	public void testDeploy() {
		List<Task> taskList=taskService.createTaskQuery().list();
		for (int i = 0; i < taskList.size(); i++) {
			Task task=taskList.get(i);
			System.out.println(task.getAssignee());
			System.out.println("任务ID："+task.getId());
			System.out.println("节点名称："+task.getName());
			System.out.println(task.getOwner());
			System.out.println(task.getDescription());
			System.out.println(task.getParentTaskId());
			System.out.println(task.getProcessInstanceId());
			System.out.println("优先级："+task.getPriority());
			System.out.println(task.getCategory());
			System.out.println(task.getExecutionId());
			System.out.println(task.getProcessDefinitionId());
			System.out.println("节点ID："+task.getTaskDefinitionKey());
			System.out.println(task.getTenantId());
			System.out.println(task.getCreateTime());
			System.out.println(task.getDelegationState());
			System.out.println(task.getDueDate());
		}
	}
	
	@Test
	public void testCompleteTask(){
//		taskService.complete("32509");
		taskService.complete("30009", null, false);
		
	}
	@Test
	public void testHitory() {
		List<HistoricTaskInstance> taskList = historyService
				.createHistoricTaskInstanceQuery().taskAssignee("李丽").list();
		 if(taskList!=null && taskList.size()>0){
			 for(HistoricTaskInstance h:taskList){
				 System.out.println(h.getId());
				 System.out.println(h.getName());
				 System.out.println(h.getTaskDefinitionKey());
				 System.out.println(h.getAssignee());
				 System.out.println("------------");
			 }
		 }
	}
}
