package com.gxuts.wss.dms.controller.hr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

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
import com.gxuts.wss.dms.entity.sys.UrlInfo;
import com.gxuts.wss.dms.service.hr.RoleService;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.util.annotation.MethodName;

@Controller
@RequestMapping(value = "/role")
public class RoleController {
	RoleInfo user = new RoleInfo();
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	
	@MethodName(name="角色管理界面")
	@RequestMapping(value = "/show")
	public String show(RoleInfo user) {
		System.out.println("UserController show");
		return "roleList";
	}
	@MethodName(name="保存一个角色")
	@RequestMapping(value = "/save")
	public String save(RoleInfo user) {
		System.out.println("UserController save");
		user.setName("212");
//		roleService.save(user);
		return "test";
	}
	@MethodName(name="更新一个角色")
	@RequestMapping(value = "/update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json update(RoleInfo role,String roleUrls) {
		if(roleUrls!=null){
			List<UrlInfo> urls=new ArrayList<UrlInfo>();
			String ids[]=roleUrls.split(",");
			Set<String> set=new HashSet<String>();
			for(String id:ids){
				set.add(id);
			}
			for(String id:set){
				urls.add(new UrlInfo(Integer.parseInt(id)));
			}
			role.setUrls(urls);
		} 
		roleService.update(role);
		return new Json();
	}
	@MethodName(name="查看一个角色")
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id,Model m,HttpSession session) {
		List<RoleInfo> roleList=roleService.queryAll(RoleInfo.class);
		List<UrlInfo> sysUrls =roleService.queryUrlAll(UrlInfo.class);
		if(id!=null){
			
			RoleInfo info=roleService.get(RoleInfo.class, id);
			m.addAttribute("info", info);
		}
		m.addAttribute("sysUrls", sysUrls);
		m.addAttribute("roleList", roleList);
		return "roleDetail";
	}
	@MethodName(name="查询一个角色")
	@RequestMapping(value = "/get/{id}")
	public RoleInfo get(@PathVariable Integer id) {
		user.setId(id);
		user.setName("123");
		System.out.println(user);
		return user;
	}
	@MethodName(name="角色列表")
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String query(Model model,String name,Integer pageNum){
		name=(name==null)? "%":name;
		Page<RoleInfo> pages=roleService.query("from RoleInfo where name like '%"+name+"%'", null, pageNum, 17);
		model.addAttribute("name", name);
		model.addAttribute("pages", pages);
		return "roleList";
	}
	@MethodName(name="使用角色树")
	@RequestMapping(value="lookup",method={RequestMethod.POST,RequestMethod.GET})
	public String lookup(Model model,String name,Integer pageNum){
		name=(name==null)? "%":name;
		Page<RoleInfo> pages=roleService.query("from RoleInfo where name like '%"+name+"%'", null, pageNum, 17);
		model.addAttribute("name", name);
		model.addAttribute("pages", pages);
		return "roleLookup";
	}

}
