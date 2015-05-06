package com.gxuts.wss.dms.controller.csrm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.gxuts.wss.dms.entity.csrm.DrugInfo;
import com.gxuts.wss.dms.entity.csrm.PurchaseBill;
import com.gxuts.wss.dms.entity.csrm.PurchaseContractBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.csrm.PurchaseContractService;
import com.gxuts.wss.dms.service.csrm.PurchaseService;

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
		PurchaseBill info=purchaseService.get(PurchaseBill.class, id);
		model.addAttribute("info", info);
		return  "purchaseDetail";
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "CG"+no);
		return "purchaseAdd";
	}
	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(PurchaseBill purchase,HttpSession session) {
		Date nd=new Date();
		purchase.setCreateUser((UserInfo)session.getAttribute("loginUser"));
		purchase.setCreateDate(nd);
		int size=purchase.getDrugs().size();
		List<DrugInfo> list=purchase.getDrugs();
		for (int i = 0; i < size; i++) {
			list.get(i).setCreateDate(nd);
		}
		purchaseService.save(purchase);
		return new Json("成功", "200", "customerList", "customerList", null,null);
	}
	
}
