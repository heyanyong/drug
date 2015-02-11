package com.gxuts.wss.dms.service.process;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import com.gxuts.wss.dms.entity.FlowEntity;




public interface WorkflowService {
	public void startProcess(String businessKey,Map<String, Object> variables);
	public void queryTask(String userNo);
	public void queryTaskHistory(String userNo);
	public void completeTask(String taskId,Map<String, Object> variables);
 

}
