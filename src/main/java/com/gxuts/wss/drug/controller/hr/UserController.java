package com.gxuts.wss.drug.controller.hr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gxuts.wss.drug.entity.UserInfo;
import com.gxuts.wss.drug.service.hr.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	UserInfo user = new UserInfo();
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/save")
	public String save(UserInfo user) {
		System.out.println("UserController save");
		user.setName("212");
//		userService.save(user);
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
		System.out.println(user);
		if(user.getNo().equals("a")){
			request.setAttribute("loginMsg", "登陆失败");
			return "login";
		}
		request.getSession().setAttribute("loginUser", user);
		return "redirect:/index.jsp";
	}
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register( ){
	 
		return "redirect:/index.jsp";
	}

}
