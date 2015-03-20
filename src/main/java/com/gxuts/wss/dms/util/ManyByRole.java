package com.gxuts.wss.dms.util;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;

public class ManyByRole implements TaskListener {
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
		List<String> users=new MysqlUtil().manyByRole(role);
		delegateTask.setVariable("assigneeList", users);
		System.out.println("users Listener");
		
	}

}