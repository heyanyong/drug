package com.gxuts.wss.dms.service.process.impl;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.process.FlowUserService;

@SuppressWarnings("serial")
public class DepartmentOneRole implements TaskListener, Serializable {
	@Autowired
	private FlowUserService flowUserService;
	private Expression roleName;

	public Expression getRoleName() {
		return roleName;
	}
	public void setRoleName(Expression roleName) {
		this.roleName = roleName;
	}

	@Override
	public void notify(DelegateTask delegateTask) {
		String role = roleName.getExpressionText();
		int departmentId=(int) delegateTask.getVariable("departmentId");
		UserInfo user=flowUserService.departmentOneRole(departmentId, role);
		delegateTask.setAssignee(user.getNo());
		System.out.println("DepartmentOneRole Listener");
		
	}

}
