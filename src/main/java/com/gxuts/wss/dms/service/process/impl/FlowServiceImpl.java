package com.gxuts.wss.dms.service.process.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.service.process.FlowService;
@Service("flowService")
public class FlowServiceImpl implements FlowService {
	/**部署流程定义*/
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService ;
	@Autowired
	private TaskService taskService ;
	public void deployByZIP(File file, String filename) {
		try {
			ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
			repositoryService.createDeployment()//
							.name(filename)//
							.addZipInputStream(zipInputStream)//
							.deploy();//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**查询新版本部署流程定义*/
	public Page<ProcessDefinition> queryDeploy(Integer currentPage, Integer numPerPage){
		List<ProcessDefinition> data=repositoryService.createProcessDefinitionQuery()//
				.latestVersion()//
				.listPage(currentPage, numPerPage);
		Page<ProcessDefinition> page=new Page<ProcessDefinition>();
		page.setCurrentPage(currentPage);
		page.setData(data);
		page.setTotalCount(data.size());
		page.setPageNumShown(5);
		page.setNumPerPage(numPerPage);
		return page;
	}
	public ProcessInstance startProcess(String processDefinitionKey,String businessKey,Map<String,Object> variables){
		ProcessInstance processInstance=runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey,variables);
		return processInstance;
	}
	@Override
	public Page<Task> queryPersonTask(String no,Integer currentPage, Integer numPerPage) {
		List<Task> data=taskService.createTaskQuery().taskAssignee(no).listPage(currentPage, numPerPage);
		int count=taskService.createTaskQuery().taskAssignee(no).list().size();
		Page<Task> page=new Page<Task>();
		page.setCurrentPage(currentPage);
		page.setData(data);
		page.setTotalCount(count);
		page.setPageNumShown(5);
		page.setNumPerPage(numPerPage);
		return page;
	}
}
