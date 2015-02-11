package com.gxuts.wss.dms.controller.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxuts.wss.dms.entity.hr.LeaveBill;
import com.gxuts.wss.dms.service.hr.LeaveBillService;

@Controller
@RequestMapping(value = "/leave")
public class LeaveBillController {
	@Autowired
	private LeaveBillService leaveBillService;
	
	@RequestMapping(value="/save")
	public String  save(LeaveBill leaveBill){
		leaveBillService.save(leaveBill);
		return "leaveList";
		
	}
}
