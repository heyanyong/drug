package com.gxuts.wss.dms.controller.hr;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.service.hr.SignService;

@Controller
@RequestMapping(value="sign")
public class SignController {
	@Autowired
	private SignService signService;
	
	@RequestMapping(value="list")
	public String queryList(HttpServletRequest request,Integer currentPage, Integer row){
		Page<SignInfo> pages=signService.query("from SignInfo", null, currentPage, row);
		request.setAttribute("pages", pages);
		return "signList";
	}
}
