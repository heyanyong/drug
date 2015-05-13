package com.gxuts.wss.drug.service.flow;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.drools.core.command.GetVariableCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.service.process.FlowService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
//@Transactional
//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestFlowService {
	@Autowired
	private FlowService flowService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService ;
	@Autowired
	private TaskService taskService ;
	@Autowired
	private HistoryService historyService;
	//zip部署测试
	@Test
	public void testDeployByZIP(){
		File file=new File("D:\\leave.zip");
		String filename="请假";
		flowService.deployByZIP(file, filename);
	}
	//查看所有最新部署流程定义
	@Test
	public void queryDeploy(){
		Page<ProcessDefinition> page=flowService.queryDeploy(0, 20);
		List<ProcessDefinition> list=page.getData();
		for (int i = 0; i < list.size(); i++) {
			ProcessDefinition a=list.get(i);
			System.out.println(a.getName()+a.getVersion()+a.getKey()+a.getDeploymentId()+a.getDescription());
		}
	}
	//b2为key=controllor b3为id
	@Test
	public void testStart(){
		String processDefinitionKey="leave";
		String businessKey="商务部#李四#CY001#请假申请#leave#1#LeaveBill";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("creater", "管理员(admin)");
		variables.put("departmentId", 10);
		variables.put("billId", 1);
		variables.put("outcome", 1);
		variables.put("roleGrade", 300);
		variables.put("mapping", "leave");
		variables.put("assignee", "assignee1");
//		List<String> assigneeList=null;
		variables.put("assigneeList",null);
		flowService.startProcess(processDefinitionKey, businessKey, variables);
	}
	//个人任务测试：任务名称 任务key 表单ID
	@Test
	public void testQueryTask(){
		Page<Object[]> page=flowService.queryPersonTask("CY009", 0, 10);
		List<Object[]> list=page.getData();
		 for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).length; j++) {
				Object[] obj=list.get(i);
				System.out.print(obj[j]);
			}
			System.out.println();
		}
	}
	@Test
	public void testQueryTaskHistory(){
		Page<Object[]> page=flowService.queryPersonTaskHistory("admin", 0, 10);
		List<Object[]> list=page.getData();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).length; j++) {
				Object[] obj=list.get(i);
				System.out.print(obj[j]+"-");
			}
			System.out.println();
		}
	}
	@Test
	public void getVariable(){
		int s=(int) runtimeService.getVariable("77515", "roleGrade");
		System.out.println(s);
	}
	
	//办理
	@Test
	public void testDealTask(){
		String result=flowService.dealTask("87511", "85001", 1, "好");
	}
	//查批注信息 1节点名称 2办理时间-3完成时间 4办理人5 批注
	@Test
	public void testComment(){
		List<Object[]> list=flowService.getCommentByprocessInstance("40001");
		 for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).length; j++) {
					Object[] obj=list.get(i);
					System.out.print(obj[j]);
				}
				System.out.println();
			}
	}
	//跳转
	@Test
	public void testJump(){
		flowService.transfer("7516", "赵什么(CY004)");
	}
	//撤消
	@Test
	public void cancelProcessInstance(){
		flowService.recall("5001", "哈哈");
	}

}
