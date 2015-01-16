package com.gxuts.wss.drug.activite;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.DeploymentBuilder;
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

	@Test
	public void testGetEngin() {
		System.out.println(repositoryService);
	}

	@Test
	public void testExport() {
		DeploymentBuilder builder = repositoryService.createDeployment();
		builder.addClasspathResource("process/export.bpmn");
		builder.deploy();
		// select * from ACT_GE_PROPERTY;这时这个表中会多条数据
		runtimeService.startProcessInstanceByKey("export");// 启动流程，ID必须与你配置的一致
		System.out.println("over......");
	}
}
