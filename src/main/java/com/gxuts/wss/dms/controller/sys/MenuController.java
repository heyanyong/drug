package com.gxuts.wss.dms.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gxuts.wss.dms.entity.sys.MenuInfo;
import com.gxuts.wss.dms.service.sys.MenuService;
import com.gxuts.wss.dms.service.hr.UserService;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="show",method={RequestMethod.POST,RequestMethod.GET})
	public String page(Model model){
		return "menuList";
	}
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<MenuInfo> query(Model model){
		System.out.println("Menu list");
		List<MenuInfo> list=menuService.queryAll();
		return list;
	}
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String save(Model model,MenuInfo menu){
		System.out.println(menu);
		menuService.save(menu);
		return "menuList";
	}
	@RequestMapping(value="update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String update(Model model,MenuInfo menu){
		System.out.println(menu);
		menuService.update(menu);
		return "menuList";
	}
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String delete(Model model,MenuInfo menu){
		System.out.println(menu);
		menuService.delete(menu);
		return "menuList";
	}
	
}
