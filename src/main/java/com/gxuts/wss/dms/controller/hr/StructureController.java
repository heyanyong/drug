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
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.StructureService;
import com.gxuts.wss.dms.service.hr.UserService;

@RestController
@RequestMapping(value = "/structure")
public class StructureController {
	@Autowired
	private StructureService structureService;
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String query(Model model,String name,Integer pageNum){
		name=(name==null)? "%":name;
		Page<StructureInfo> pages=structureService.query("from StructureInfo where name like '%"+name+"%'", null, pageNum, 17);
		model.addAttribute("name", name);
		model.addAttribute("pages", pages);
		return "structureList";
	}
}
