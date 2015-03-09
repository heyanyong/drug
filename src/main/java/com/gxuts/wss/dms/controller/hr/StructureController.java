package com.gxuts.wss.dms.controller.hr;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.StructureService;
import com.gxuts.wss.dms.service.hr.UserService;

@Controller
@RequestMapping(value = "/structure")
public class StructureController {
	@Autowired
	private StructureService structureService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="show",method={RequestMethod.POST,RequestMethod.GET})
	public String page(Model model){
		return "structureList";
	}
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<StructureInfo> query(Model model){
		System.out.println("Structure list");
		List<StructureInfo> result=new ArrayList<StructureInfo>();
		List<StructureInfo> list=structureService.queryAll();
		List<UserInfo> users=userService.queryAll(UserInfo.class);
//		for (int i = 0; i < users.size(); i++) {
//			for (int j = 0; j < list.size(); j++) {
//				int uid=users.get(i).getStructure().getId();
//				int sid=list.get(j).getId();
//				if(uid==sid){
//				}
//			}
//		}
		System.out.println(list);
		return list;
	}
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String save(Model model,HttpServletRequest q){
		String t=q.getParameter("id");
		String t3=q.getParameter("name");
		System.out.println(t);
		System.out.println(t3);
		return "structureList";
	}
	@RequestMapping(value="update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String update(Model model){
		System.out.println("update");
		return "structureList";
	}
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String delete(Model model){
		System.out.println("delete");
		return "structureList";
	}
	
}
