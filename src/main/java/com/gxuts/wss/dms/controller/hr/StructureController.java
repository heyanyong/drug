package com.gxuts.wss.dms.controller.hr;

import java.util.List;

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
	
	@RequestMapping(value="show",method={RequestMethod.POST,RequestMethod.GET})
	public String page(Model model){
		return "structureList";
	}
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<StructureInfo> query(Model model){
		System.out.println("Structure list");
		List<StructureInfo> list=structureService.queryAll();
		System.out.println(list);
		return list;
	}
}
