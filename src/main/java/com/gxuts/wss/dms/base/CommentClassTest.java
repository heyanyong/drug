package com.gxuts.wss.dms.base;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.gxuts.wss.dms.service.hr.UserService;
@Controller
public class CommentClassTest<F> {
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	public void say(){
		System.out.println("Class TEST:"+taskService);
		System.out.println("Class TEST UserService:"+userService);
	}
	public F test(F f){
		return f;
	}
}
