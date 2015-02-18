package com.gxuts.wss.dms.controller.business;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.service.business.PurchaseContractService;

 
@Controller
@RequestMapping(value = "/contract")
public class PurchaseContractController {
	@Autowired
	private PurchaseContractService purchaseContractService;

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
	@RequestMapping(value="/fromPurchase")
	public String fromPurchase(Integer purchaseId,Model model){
		PurchaseContractBill contract=purchaseContractService.fromPurchase(purchaseId);
		model.addAttribute("contract", contract);
		return "contractDetail";
		
	}
	 


	 
}
