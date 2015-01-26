package com.gxuts.wss.drug.activite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Attachment;
import org.activiti.engine.task.Comment;
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
	//52501
	@Test
	public void testStart(){
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("leave");
		System.out.println("启动ID："+processInstance.getId());
		System.out.println("启动名称："+processInstance.getName());
		System.out.println(processInstance.getProcessDefinitionVersion());
		
	}
	//all task
	@Test
	public void testQueryAllTask(){
		List<Task> taskList=taskService.createTaskQuery().active().list();
		for(Task t:taskList){
			System.out.println(t.getAssignee());
			System.out.println(t.getId());
			System.out.println(t.getName());
			System.out.println(""+t.getProcessInstanceId());
			System.out.println("----------");  
		}
	}
	//系统任务
	@Test
	public void testSystemTask(){
		List<Task> taskList=taskService.createTaskQuery().list();
		for(Task t:taskList){
			System.out.println(t.getAssignee());
			System.out.println(t.getId());
			System.out.println(t.getName());
			System.out.println(""+t.getProcessInstanceId());
			System.out.println("----------");  
		}
	}
	/*张三
	52504
	提交申请
	52501*/
	@Test
	public void testQueryTask(){
		String assignee="张三";
		List<Task> taskList=taskService.createTaskQuery().taskAssignee(assignee).active().list();
		for(Task t:taskList){
			System.out.println(t.getAssignee());
			System.out.println(t.getId());
			System.out.println(t.getName());
			System.out.println(t.getProcessDefinitionId());
			System.out.println(""+t.getProcessInstanceId());
			System.out.println("----------");  
		}
	}
	//办理10004
	@Test
	public void testComplete(){
		String taskId="52504";
		String processInstanceId="52501";
		String type = null;
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("message", "同意");
		taskService.addComment(taskId, processInstanceId, type, "总监意见：真好");
		taskService.complete(taskId, variables);
		System.out.println("完成");
		
	}
	//7501 10001
	@Test
	public void testCurrent(){
		ProcessInstance pi= runtimeService.createProcessInstanceQuery().processInstanceId("5001").singleResult();
		System.out.println(pi.getActivityId());
	}
	@Test
	public void testHistoryTask(){
		String processInstanceId="10001";
		List<HistoricTaskInstance> historyTaskList=historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();
		for (HistoricTaskInstance h:historyTaskList ) {
			System.out.println(h.getAssignee());
			System.out.println(h.getName());
		}
	}
	//获取审批意见
	@Test
	public void testComment(){
		String taskId="45004";
		String processInstanceId="45001";
		List<Comment> comment =taskService.getProcessInstanceComments(processInstanceId);
//		List<Comment> comment=taskService.getTaskComments(taskId);
		for(Comment a:comment){
			System.out.print(a.getFullMessage());
			System.out.print(a.getUserId());
			System.out.print(a.getType());
			System.out.print(a.getTime());
			System.out.println();
		}
	}
	@Test
	public void  testImg(){
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey("leave");
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()//创建流程定义查询对象，对应表act_re_procdef 
				.processDefinitionId(processInstance.getProcessDefinitionId())//使用流程定义ID查询
				.singleResult();
		System.out.println(pd.getDiagramResourceName());
	}
	
}
