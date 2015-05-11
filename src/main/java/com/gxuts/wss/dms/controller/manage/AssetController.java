package com.gxuts.wss.dms.controller.manage;

import java.util.Date;
import java.util.List;

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
import com.gxuts.wss.dms.entity.csrm.CustomerInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.AssetInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.manage.AssetService;
import com.gxuts.wss.dms.service.hr.UserService;

@Controller
@RequestMapping(value = "/asset")
public class AssetController {
	@Autowired
	private AssetService assetService;
	
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<AssetInfo> pages = assetService.query(null, null, null, null);
		model.addAttribute("pages", pages);
		return "assetList";
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "ZX"+no);
		return "assetAdd";
	}
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json save(Model model,AssetInfo asset,HttpSession session){
		asset.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		asset.setCreateDate(new Date());
		assetService.save(asset);
		return new Json();
	}
	@RequestMapping(value = "/view/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		AssetInfo asset = assetService.get(AssetInfo.class, id);
		System.out.println(asset);
		model.addAttribute("info", asset);
		return "assetView";
	}
	@RequestMapping(value="update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json update(Model model,AssetInfo asset){
		System.out.println(asset);
		assetService.update(asset);
		return new Json();
	}
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json delete(Model model,AssetInfo asset){
		System.out.println(asset);
		assetService.delete(asset);
		return new Json();
	}
	
}
