package com.gxuts.wss.drug.controller.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gxuts.wss.drug.entity.UserInfo;
import com.gxuts.wss.drug.service.hr.UserService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
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
	public UserInfo get(@PathVariable Integer id) {
		user.setId(id);
		user.setName("123");
		System.out.println(user);
		return user;
	}

}
