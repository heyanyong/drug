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
import com.gxuts.wss.dms.entity.manage.AssetPurchaseContractBill;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.manage.AssetPurchaseContractService;

@Controller
@RequestMapping(value = "/assetPurchase")
public class AssetPurchaseContractController {
	@Autowired
	private AssetPurchaseContractService assetPurchaseService;
	
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<AssetPurchaseContractBill> pages = assetPurchaseService.query(null, null, null, null);
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
	public Json save(Model model,AssetPurchaseContractBill assetPurchase,HttpSession session){
		assetPurchase.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		assetPurchase.setCreateDate(new Date());
		assetPurchaseService.save(assetPurchase);
		return new Json();
	}
	@RequestMapping(value = "/view/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		AssetPurchaseContractBill assetPurchase = assetPurchaseService.get(AssetPurchaseContractBill.class, id);
		model.addAttribute("info", assetPurchase);
		return "assetPurchaseView";
	}
	@RequestMapping(value="update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json update(Model model,AssetPurchaseContractBill assetPurchase){
		assetPurchaseService.update(assetPurchase);
		return new Json();
	}
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json delete(Model model,AssetPurchaseContractBill assetPurchase){
		assetPurchaseService.delete(assetPurchase);
		return new Json();
	}
	
}
