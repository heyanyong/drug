package com.gxuts.wss.dms.controller.hr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.CommentClassTest;
import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	UserInfo user = new UserInfo();
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@RequestMapping(value="list")
	public String getList(HttpServletRequest request,Integer currentPage, Integer row){
		Page<UserInfo> pages=userService.query("from UserInfo", null, currentPage, row);
		request.setAttribute("pages", pages);
		return "userList";
	}

	@RequestMapping(value = "/save")
	public String save(UserInfo user) {
		System.out.println("UserController save");
		user.setName("212");
		CommentClassTest t=new CommentClassTest();
		t.say();
//		userService.save(user);
		System.out.println("cc:"+taskService);
		System.out.println("ccu:"+userService);
		return "test";
	}

	@RequestMapping(value = "/get/{id}")
	@ResponseBody
	public UserInfo get(@PathVariable Integer id) {
		user=userService.get(UserInfo.class, id);
		return user;
	}
	@RequestMapping(value="login")
	public String LoginPage(){
		return "login";
	}
	@RequestMapping(value="/checkLogin", method=RequestMethod.POST)
	public String checkLogin(UserInfo user , HttpServletRequest request){
		UserInfo loginUser=userService.checkLogin(user);
		if(loginUser==null){
			request.setAttribute("loginMsg", "登陆失败");
			return "login";
		}else{
			request.getSession().setAttribute("loginUser", loginUser);
			return "redirect:/index.jsp";
		}
	}
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register( ){
	 
		return "redirect:/index.jsp";
	}

}
