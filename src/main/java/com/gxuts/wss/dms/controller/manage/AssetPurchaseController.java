package com.gxuts.wss.dms.controller.manage;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.AssetPurchaseBill;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.manage.AssetPurchaseService;

@Controller
@RequestMapping(value = "/assetPurchase")
public class AssetPurchaseController {
	@Autowired
	private AssetPurchaseService assetPurchaseService;
	
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<AssetPurchaseBill> pages = assetPurchaseService.query(null, null, null, null);
		model.addAttribute("pages", pages);
		return "assetPurchaseList";
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "MGAP"+no);
		return "assetPurchaseAdd";
	}
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json save(Model model,AssetPurchaseBill assetPurchase,HttpSession session){
		assetPurchase.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		assetPurchase.setCreateDate(new Date());
		assetPurchaseService.save(assetPurchase);
		return new Json();
	}
	@RequestMapping(value = "/view/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		AssetPurchaseBill assetPurchase = assetPurchaseService.get(AssetPurchaseBill.class, id);
		System.out.println(assetPurchase);
		model.addAttribute("info", assetPurchase);
		return "assetPurchaseView";
	}
	@RequestMapping(value="update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json update(Model model,AssetPurchaseBill assetPurchase){
		System.out.println(assetPurchase);
		assetPurchaseService.update(assetPurchase);
		return new Json();
	}
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json delete(Model model,AssetPurchaseBill assetPurchase){
		System.out.println(assetPurchase);
		assetPurchaseService.delete(assetPurchase);
		return new Json();
	}
	
}
