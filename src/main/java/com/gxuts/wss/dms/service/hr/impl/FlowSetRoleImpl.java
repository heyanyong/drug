package com.gxuts.wss.dms.service.hr.impl;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowUserService;

@Service("flowSetRoleService")
@Transactional
public class FlowSetRoleImpl implements TaskListener {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	@Override
	public void notify(DelegateTask delegateTask) {
		String var=(String) delegateTask.getVariable("createUser");
		System.out.println(delegateTask.getVariable("assigneeList"));
		
		delegateTask.setVariableLocal("var1", "var1");
		System.out.println("444"+var);
		System.out.println(taskService);     //null
		System.out.println("us:"+userService);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		FlowUserService flowUserService=(FlowUserService) context.getBean("flowUserService");
		System.out.println(flowUserService);
		
	}
	 
	

}
