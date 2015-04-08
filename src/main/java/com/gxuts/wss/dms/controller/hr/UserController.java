package com.gxuts.wss.dms.controller.hr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import liquibase.util.MD5Util;

import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.util.QueryFilter;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	UserInfo user = new UserInfo();
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;

	@RequestMapping(value="find",method={RequestMethod.POST,RequestMethod.GET})
	public String find(Model model,Integer pageNum,HttpServletRequest request){
		String target=request.getParameter("show");
		QueryFilter filter = new QueryFilter(request);
		Page<UserInfo> pages=userService.find(filter);
		model.addAttribute("pages", pages);
		if("dialog".equals(target)){
			return "userListDialog";
		}
		return "userList";
	}
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String query(Model model,String name,Integer pageNum,HttpServletRequest request){
		String target=request.getParameter("show");
		name=(name==null)? "%":name;
		Page<UserInfo> pages=userService.query("from UserInfo where name like '%"+name+"%'", null, pageNum, 17);
		model.addAttribute("name", name);
		model.addAttribute("pages", pages);
		if("dialog".equals(target)){
			return "userListDialog";
		}
		return "userList";
	}
	@RequestMapping(value="lookup",method={RequestMethod.POST,RequestMethod.GET})
	public String lookup(Model model,String name,Integer pageNum){
		return "userLookup";
	}

	@RequestMapping(value = "/save",method=RequestMethod.POST)
	@ResponseBody
	public Json save(UserInfo user,HttpSession session,HttpServletRequest q) {
		String ids=q.getParameter("userAdd_roleLK.id");
		String[] rids=ids.split(",");
		List<RoleInfo> roles=new ArrayList<RoleInfo>();
		for(String i:rids){
			roles.add(new RoleInfo(Integer.parseInt(i)));
		}
		user.setRoles(roles);
		user.setCreateDate(new Date());
		user.setCreateUser((UserInfo)session.getAttribute("loginUser"));
		System.out.println("UserController save"+user);
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
	public Json update(UserInfo user,HttpSession session,HttpServletRequest q) {
		String ids=q.getParameter("userAdd_roleLK.id");
		String[] rids=ids.split(",");
		List<RoleInfo> roles=new ArrayList<RoleInfo>();
		for(String i:rids){
			roles.add(new RoleInfo(Integer.parseInt(i)));
		}
		user.setRoles(roles);
		user.setUpdateUser((UserInfo)session.getAttribute("loginUser"));
		user.setUpdateTime(new Date());
		userService.update(user);
		Json json =new Json("更新成功","200","userList","userList",null,null);
		return json;
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		UserInfo user=userService.get(UserInfo.class, id);
		List<RoleInfo> roles=user.getRoles();
		StringBuffer ids = new StringBuffer();
		StringBuffer roleNames = new StringBuffer();
		for (RoleInfo r:roles) {
			ids.append(r.getId()+",");
			roleNames.append(r.getName()+",");
		}
		model.addAttribute("roleIds", ids.substring(0, ids.length()-1));
		model.addAttribute("roleNames", roleNames.substring(0, roleNames.length()-1));
		model.addAttribute("user", user);
		return  "userDetail";
	}
	

}
