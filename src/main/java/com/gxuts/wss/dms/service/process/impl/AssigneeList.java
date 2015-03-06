package com.gxuts.wss.dms.service.process.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Service;

import com.gxuts.wss.dms.service.process.FlowService;

 
@Service
public class AssigneeList implements  TaskListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Expression roleName;
	
	public Expression getRoleName() {
		return roleName;
	}

	public void setRoleName(Expression roleName) {
		this.roleName = roleName;
	}

	@Override
	public void notify(DelegateTask delegateTask) {
		delegateTask.setVariable("assigneeList", null);
		String role = roleName.getExpressionText();
		List<String> assigneeList=Arrays.asList(role+1,role+2,role+3);
		delegateTask.setVariable("assigneeList", assigneeList);
		System.out.println("设置会签列表");
	}
 
}
