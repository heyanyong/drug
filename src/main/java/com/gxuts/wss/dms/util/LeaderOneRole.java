package com.gxuts.wss.dms.util;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;

public class LeaderOneRole implements TaskListener {
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
		String userNo=new MysqlUtil().getLeaderOndRole(departmentId, role);
		delegateTask.setAssignee(userNo);
		System.out.println("LeaderOneRole Listener");
		
	}

}