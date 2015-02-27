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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.business.PurchaseContractService;
import com.gxuts.wss.dms.service.business.PurchaseService;

import org.springframework.ui.Model;
 
@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping(value="get")
	@ResponseBody
	public PurchaseBill get(){
		PurchaseBill purchase=purchaseService.get(PurchaseBill.class, 11);
		purchase.setId(34);
		
		return purchase;
	}
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	@ResponseBody
	public Json delete(Integer e_id) {
		System.out.println("p delete"+e_id);
		purchaseService.delete(new PurchaseBill(e_id));
		Json json=new Json();
		json.setStatusCode("200");
		json.setRel("purchaseList");
		json.setNavTabId("purchaseList");
		return json;
	}
	
	@RequestMapping(value="list")
	public String getList(HttpServletRequest request,Integer currentPage, Integer row,Model model){
		 Page<PurchaseBill> pages=purchaseService.query(null, null, null, null);
		 model.addAttribute("pages",pages);
		return "purchaseList";
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		PurchaseBill purchase=purchaseService.get(PurchaseBill.class, id);
		model.addAttribute("purchase", purchase);
		return  "purchaseDetail";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(PurchaseBill purchase) {
		System.out.println(purchase);
		purchaseService.save(purchase);
		Json j=new Json();
		if("李".equals(purchase.getName())){
			j.setMessage("李");
			j.setStatusCode("300");
			j.setForwardUrl("test.jsp");
		}
		return j;
	}
	
}
