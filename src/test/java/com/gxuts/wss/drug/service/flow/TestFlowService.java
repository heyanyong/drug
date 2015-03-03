package com.gxuts.wss.drug.service.flow;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.service.process.FlowService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestFlowService {
	@Autowired
	private FlowService flowService;
	
	//zip部署测试
	@Test
	public void testDeployByZIP(){
		File file=new File("D:\\flowtest.zip");
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
	@Test
	public void testStart(){
		String processDefinitionKey="leave";
		String businessKey="NF00012#leave#1001";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("creater", "NF0001");
		List<String> assigneeList=Arrays.asList("liyagn","cooperay","other");
		variables.put("assigneeList", assigneeList);
		ProcessInstance a=flowService.startProcess(processDefinitionKey, businessKey, variables);
		System.out.println(a);
	}

}
