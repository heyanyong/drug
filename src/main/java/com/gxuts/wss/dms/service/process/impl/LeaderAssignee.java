package com.gxuts.wss.dms.service.process.impl;

import java.util.Map;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Service;

import com.gxuts.wss.dms.service.process.WorkflowService;

 
@Service
public class LeaderAssignee implements  TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {
		//delegateTask.setVariable("assignee", "主管一");
		delegateTask.setAssignee("主管一");
		System.out.println("设置上级领导");
	}

	 
 
 
 
}
