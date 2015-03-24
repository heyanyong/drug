package com.gxuts.wss.dms.service.process;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.FlowEntity;
public interface FlowService {
	public void deployByZIP(File file, String filename);
	public Page<ProcessDefinition> queryDeploy(Integer currentPage, Integer numPerPage);
	public ProcessInstance startProcess(String processDefinitionKey,String businessKey,Map<String,Object> variables);
	public Page<Object[]> queryPersonTask(String no,Integer currentPage, Integer numPerPage);
	public Page<Object[]> queryPersonTaskHistory(String no, Integer currentPage,Integer numPerPage);
	public String dealTask(String taskId,String processInstanceId, int outcome, String comment) ;
	public List<Object[]> getCommentByprocessInstance(String processInstanceId);
	public String transfer(String taskId, String assignee);
}
