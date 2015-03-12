package com.gxuts.wss.dms.controller.hr;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.CommentClassTest;
import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.Json;
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

//	@RequestMapping(value="list")
//	public String getList(Model model,Integer pageNum, Integer row){
//		Page<UserInfo> pages=userService.query("from UserInfo", null, pageNum, 3);
//		model.addAttribute("pages", pages);
//		return "userList";
//	}
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String query(Model model,String name,Integer pageNum){
		name=(name==null)? "%":name;
		Page<UserInfo> pages=userService.query("from UserInfo where name like '%"+name+"%'", null, pageNum, 17);
		model.addAttribute("name", name);
		model.addAttribute("pages", pages);
		return "userList";
	}
	@RequestMapping(value="lookup",method={RequestMethod.POST,RequestMethod.GET})
	public String lookup(Model model,String name,Integer pageNum){
		Page<UserInfo> pages=userService.query("from UserInfo where name like '%"+name+"%'", null, pageNum, 17);
		model.addAttribute("name", name);
		model.addAttribute("pages", pages);
		return "userLookup";
	}

	@RequestMapping(value = "/save",method=RequestMethod.POST)
	@ResponseBody
	public Json save(UserInfo user,HttpSession session) {
		System.out.println("UserController save"+user);
		user.setCreateDate(new Date());
		user.setCreateUser((UserInfo)session.getAttribute("loginUser"));
		userService.save(user);
		Json json =new Json("成功","200","userList","userList",null,null);
		return json;
	}

	@RequestMapping(value = "/get/{id}")
	@ResponseBody
	public UserInfo get(@PathVariable Integer id) {
		user=userService.get(UserInfo.class, id);
		return user;
	}
	@RequestMapping(value = "/reset/{id}")
	@ResponseBody
	public Json reset(@PathVariable Integer id) {
		userService.reset(id);
		return new Json("成功","200","userList","userList",null,null);
	}
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		userService.delete(new UserInfo(id));
//		Json json =new Json("测试","200",null,"userList","forwardConfirm","user/edit/1");
		Json json =new Json("成功","200","userList","userList",null,null);
		return json;
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Json update(UserInfo user) {
		userService.update(user);
		Json json =new Json("更新成功","200","userList","userList",null,null);
		return json;
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		UserInfo user=userService.get(UserInfo.class, id);
		model.addAttribute("user", user);
		return  "userDetail";
	}
	@RequestMapping(value="login")
	public String LoginPage(){
		return "login";
	}
	@RequestMapping(value="/checkLogin", method=RequestMethod.POST)
	public String checkLogin(UserInfo user , HttpServletRequest request){
		System.out.println(user);
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
