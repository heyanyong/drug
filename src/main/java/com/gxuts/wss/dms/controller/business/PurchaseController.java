package com.gxuts.wss.dms.controller.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.service.business.PurchaseContractService;
import com.gxuts.wss.dms.service.business.PurchaseService;

 
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private PurchaseContractService purchaseContractService;
	
	@RequestMapping(value="get")
	@ResponseBody
	public PurchaseBill get(){
		PurchaseBill purchase=purchaseService.get(PurchaseBill.class, 11);
		purchase.setId(34);
		
		return purchase;
	}
	
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
	
	@RequestMapping(value="toContract")
	public void purchaseToContract(){
		System.out.println(111);
		PurchaseBill purchase=purchaseService.get(PurchaseBill.class, 11);
		PurchaseContractBill contract=new PurchaseContractBill();
		List<DrugInfo> newdrugs=new ArrayList<DrugInfo>();
		List<DrugInfo> olddrugs=purchase.getDrugs();
		for(DrugInfo d:olddrugs){
			d.setId(null);
		}
		purchaseContractService.save(contract);
	}
	 


	 
}
