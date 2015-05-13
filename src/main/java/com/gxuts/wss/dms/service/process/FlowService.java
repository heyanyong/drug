package com.gxuts.wss.dms.service.process;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;

import com.gxuts.wss.dms.base.Page;
public interface FlowService {
	public void deployByZIP(File file, String filename);
	public Page<ProcessDefinition> queryDeploy(Integer currentPage, Integer numPerPage);
	public String startProcess(String processDefinitionKey,String businessKey,Map<String,Object> variables);
	public Page<Object[]> queryPersonTask(String no,Integer currentPage, Integer numPerPage);
	public Page<Object[]> queryPersonTaskHistory(String no, Integer currentPage,Integer numPerPage);
	public String dealTask(String taskId,String processInstanceId, int outcome, String comment) ;
	public List<Object[]> getCommentByprocessInstance(String processInstanceId);
	/**
	 * 任务转交
	 * @param taskId
	 * @param assignee
	 * @return
	 */
	public String transfer(String taskId, String assignee);
	/**
	 * 撤消
	 * @param 流程实例ID
	 * @param 撤销原因
	 */
	public void recall(String instanceId,String reason);
	public Page<Object[]> instanceList(String bk, String startTime, String endTime, int parseInt);
}
