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
	@RequestMapping(value="lookup",method={RequestMethod.POST,RequestMethod.GET})
	public String lookup(Model model){
		System.out.println("Structure lookup");
		List<StructureInfo> result=new ArrayList<StructureInfo>();
		List<StructureInfo> list=structureService.queryAll();
		Page<StructureInfo> page=new  Page<StructureInfo>();
		page.setData(list);
		model.addAttribute("pages", page);
		return "structureLookup";
	}
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<StructureInfo> query(String all){
		List<StructureInfo> list=structureService.queryAll();
		if(all!=null){
			List<UserInfo> users=userService.queryAll(UserInfo.class);
			for(UserInfo u:users){
				list.add(new StructureInfo(u.getId()+100, u.getName(), u.getStructure().getId(),false,"images/diy/user.png"));
			}
		}
		return list;
	}
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String save(Model model,StructureInfo structure){
		System.out.println(structure);
		structureService.save(structure);
		return "structureList";
	}
	@RequestMapping(value="update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String update(Model model,StructureInfo structure){
		System.out.println(structure);
		structureService.update(structure);
		return "structureList";
	}
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String delete(Model model,StructureInfo structure){
		System.out.println(structure);
		structureService.delete(structure);
		return "structureList";
	}
	
}
