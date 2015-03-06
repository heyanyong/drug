package com.gxuts.wss.dms.service.process.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Comment;
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
	public Page<Object[]> queryPersonTask(String no,Integer currentPage, Integer numPerPage) {
		List<Task> list=taskService.createTaskQuery().taskAssignee(no).orderByTaskCreateTime().asc().listPage(currentPage, numPerPage);
		List<Object[]> data=new ArrayList<Object[]>();
		for(Task t:list){
			Object[] pt=new Object[11];
			pt[0]=t.getId();
			pt[1]=t.getName();
			pt[2]=t.getAssignee();
			pt[3]=t.getCreateTime();
			pt[4]=t.getDueDate();
			pt[5]=t.getProcessInstanceId();
			ProcessInstance p=runtimeService.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).singleResult();
			String[] bk=p.getBusinessKey().split("#");
			pt[6]=bk[0];
			pt[7]=bk[1];
			pt[8]=bk[2];
			pt[9]=bk[3];
			pt[10]=bk[4];
			data.add(pt);
		}
		int totalCount=taskService.createTaskQuery().taskAssignee(no).list().size();
		return new Page<Object[]>(data, currentPage, numPerPage, totalCount);
	}
	public void dealTask(String taskId,String processInstanceId, String outcome, String comment) {
		taskService.addComment(taskId, processInstanceId, comment);
		taskService.complete(taskId);
		taskService.setVariable(taskId, "outcome", outcome);
		
	}
	public List<Comment> getCommentByprocessInstance(String processInstanceId){
		List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
		return list;
	}
}
