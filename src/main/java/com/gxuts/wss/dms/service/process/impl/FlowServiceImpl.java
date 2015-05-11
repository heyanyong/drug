package com.gxuts.wss.dms.service.process.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowService;
@Service("flowService")
@Transactional
public class FlowServiceImpl implements FlowService {
	/**部署流程定义*/
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService ;
	@Autowired
	private TaskService taskService ;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private UserService userService;
	
	
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
	public String startProcess(String processDefinitionKey,String businessKey,Map<String,Object> variables){
		ProcessInstance pi=runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey,variables);
		Task task=taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		taskService.addComment(task.getId(), pi.getId(),"提交");
		taskService.complete(task.getId());
		List<Task> tasks= taskService.createTaskQuery().processInstanceId(pi.getId()).active().list();
		String result = "";
		for(Task t:tasks){
			result+=t.getName()+"("+t.getAssignee()+") ";
		}
		String[] bk=businessKey.split("#");
		userService.executeHql("update "+bk[6]+" set status=2,flowId= "+ pi.getId() + " where id= " + bk[5]);
		return result;
	}
	@Override
	public Page<Object[]> queryPersonTask(String no,Integer currentPage, Integer numPerPage) {
		List<Task> list=taskService.createTaskQuery().taskAssignee(no).orderByTaskCreateTime().asc().listPage(currentPage, numPerPage);
		List<Object[]> data=new ArrayList<Object[]>();
		for(Task t:list){
			Object[] pt=new Object[12];
			pt[0]=t.getId();
			pt[1]=t.getName();
			pt[2]=t.getAssignee();
			pt[3]=t.getCreateTime();
			pt[4]=t.getDueDate();
			pt[5]=t.getProcessInstanceId();
			ProcessInstance p=runtimeService.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).singleResult();
			String[] bk=p.getBusinessKey().split("#");
			pt[6]=bk[0];  //部门
			pt[7]=bk[1];  //姓名
			pt[8]=bk[2];  //工号
			pt[9]=bk[3];  //任务名
			pt[10]=bk[4]; //url
			pt[11]=bk[5]; //Billid
			data.add(pt);
		}
		int totalCount=taskService.createTaskQuery().taskAssignee(no).list().size();
		return new Page<Object[]>(data, currentPage, numPerPage, totalCount);
	}
	@Override
	public Page<Object[]> queryPersonTaskHistory(String no,Integer currentPage, Integer numPerPage) {
		List<HistoricTaskInstance> list= historyService.createHistoricTaskInstanceQuery()
				.taskAssignee(no).finished().orderByDueDateNullsLast().desc().listPage(currentPage, numPerPage);
		List<Object[]> data=new ArrayList<Object[]>();
		for(HistoricTaskInstance t:list){
			Object[] pt=new Object[12];
			pt[0]=t.getId();
			pt[1]=t.getName();
			pt[2]=t.getAssignee();
			pt[3]=t.getCreateTime();
			pt[4]=t.getEndTime();
			pt[5]=t.getProcessInstanceId();
			ProcessInstance p=runtimeService.createProcessInstanceQuery().processInstanceId(t.getProcessInstanceId()).singleResult();
			String[] bk=p.getBusinessKey().split("#");
			pt[6]=bk[0];  //部门
			pt[7]=bk[1];  //姓名
			pt[8]=bk[2];  //工号
			pt[9]=bk[3];  //任务名
			pt[10]=bk[4]; //url
			pt[11]=bk[5]; //Billid
			data.add(pt);
		}
		return new Page<Object[]>(data, currentPage, numPerPage, 0);
	}
	
	//
	public String dealTask(String taskId,String processInstanceId, int outcome, String message) {
		taskService.addComment(taskId, processInstanceId, outcome==1? "同意":"不同意", message);
		taskService.setVariable(taskId, "outcome", outcome);
		ProcessInstance p=runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		taskService.complete(taskId);
		List<Task> tasks= taskService.createTaskQuery().processInstanceId(processInstanceId).active().list();
		String result = "";
		for(Task t:tasks){
			result+=t.getName()+"("+t.getAssignee()+") ";
		}
		if(result.equals("")){
			String[] bk=p.getBusinessKey().split("#");
			userService.executeHql("update "+bk[6]+" set status=3 where flowId="+processInstanceId);
		}
		return result;
		
	}
	//
	public List<Object[]> getCommentByprocessInstance(String processInstanceId){
		List<Object[]> data=new ArrayList<Object[]>();
		List<HistoricTaskInstance> tasks=historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId)
				.finished()
				.list();
		List<Comment> comments = taskService.getProcessInstanceComments(processInstanceId);
		for (HistoricTaskInstance t:tasks) {
			Object[] pt=new Object[5];
			pt[0]=t.getName();
			pt[1]=t.getAssignee();
			pt[2]=t.getCreateTime();
			pt[3]=t.getEndTime();
			for(Comment c:comments){
				 if(t.getId().equals(c.getTaskId())){
					 pt[4]=c.getFullMessage();
				 } 
			}
			data.add(pt);
		}
		return data;
	}
	@Override
	public String transfer(String taskId, String assignee) {
		taskService.setAssignee(taskId, assignee);
		return assignee;
	}
	
}
