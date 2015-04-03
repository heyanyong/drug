package com.gxuts.wss.dms.controller.hr;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.service.hr.SignService;
import com.gxuts.wss.dms.util.DateUtil;

@Controller
@RequestMapping(value="sign")
public class SignController {
	@Autowired
	private SignService signService;
	
	@RequestMapping(value = "/save")
	public String save(SignInfo sign) {
		signService.save(null);
		return null;
	}
	
	@RequestMapping(value="list")
	public String queryList(HttpServletRequest request,Integer currentPage, Integer row){
		String target=request.getParameter("show");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		Map<String, Object> par=new HashMap<String,Object>();
		if(startDate!=null&&!"".equals(startDate)){
			par.put("startDate", DateUtil.string2Date(startDate, "yyyy-MM-dd"));
		}
		if(endDate!=null&&!"".equals(endDate)){
			par.put("endDate", DateUtil.string2Date(endDate, "yyyy-MM-dd"));
		}
		Page<SignInfo> pages=signService.query("from SignInfo",par, currentPage, row);
		request.setAttribute("pages", pages);
		if("dialog".equals(target)){
			return "signListDialog";
		}
		return "signList";
	}
}
