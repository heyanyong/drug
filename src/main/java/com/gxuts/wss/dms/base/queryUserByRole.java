package com.gxuts.wss.dms.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class queryUserByRole implements TaskListener, Serializable {
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
		System.out.println(role);
//		System.out.println(delegateTask.getVariable("creater"));
//		delegateTask.setVariable("createUser", "李四一");
//		Map<String, Object> variables=new HashMap<String, Object>();
//		variables.put("createUser", "NF0001");
//		delegateTask.setVariables(variables);
		Object a=delegateTask.getVariable("createUser");
		System.out.println(a);
		
	}

}
