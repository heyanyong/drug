package com.gxuts.wss.dms.controller.business;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxuts.wss.dms.entity.business.PurchaseContractBill;

 
@Controller
@RequestMapping(value = "/contract")
public class PurchaseContractController {

	@RequestMapping(value="list")
	public String getList(HttpServletRequest request,Integer currentPage, Integer row){
		 
		return "userList";
	}

	@RequestMapping(value = "/save")
	public String save(PurchaseContractBill contract) {
		System.out.println(contract);
		System.out.println(contract.getCreateDate());
		System.out.println(contract.getUpdateDate());
		return "test";
	}
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
	        dateFormat.setLenient(false);
	        dateFormat2.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat2, false));
	    }


	 
}
