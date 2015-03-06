package com.gxuts.wss.dms.controller.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.service.hr.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
	RoleInfo user = new RoleInfo();
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/save")
	public String save(RoleInfo user) {
		System.out.println("UserController save");
		user.setName("212");
//		roleService.save(user);
		return "test";
	}

	@RequestMapping(value = "/get/{id}")
	public RoleInfo get(@PathVariable Integer id) {
		user.setId(id);
		user.setName("123");
		System.out.println(user);
		return user;
	}
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String query(Model model,String name,Integer pageNum){
		name=(name==null)? "%":name;
		Page<RoleInfo> pages=roleService.query("from RoleInfo where name like '%"+name+"%'", null, pageNum, 17);
		model.addAttribute("name", name);
		model.addAttribute("pages", pages);
		return "sysroleList";
	}

}
