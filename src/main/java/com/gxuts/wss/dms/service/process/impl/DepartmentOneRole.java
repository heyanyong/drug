package com.gxuts.wss.dms.service.process.impl;

import java.io.Serializable;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

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
		System.out.println(flowUserService+"11111111"+role);
//		System.out.println(delegateTask.getVariable("creater"));
//		delegateTask.setVariable("createUser", "李四一");
//		Map<String, Object> variables=new HashMap<String, Object>();
//		variables.put("createUser", "NF0001");
//		delegateTask.setVariables(variables);
		Object a=delegateTask.getVariable("createUser");
		System.out.println(a);
		
	}

}
