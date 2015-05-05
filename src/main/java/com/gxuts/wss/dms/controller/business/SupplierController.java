package com.gxuts.wss.dms.controller.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.CustomerInfo;
import com.gxuts.wss.dms.entity.business.ExportBill;
import com.gxuts.wss.dms.entity.business.SupplierInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.business.SupplierService;
import com.gxuts.wss.dms.service.business.ExportService;
import com.gxuts.wss.dms.service.business.SupplierService;
import com.gxuts.wss.dms.util.QueryFilter;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		supplierService.delete(new SupplierInfo(id));
		Json json = new Json("成功", "200", "supplierList", "supplierList", null,
				null);
		return json;
	}

	@RequestMapping(value = "list")
	public String getList(HttpServletRequest request, Integer pageNum,
			Integer row, Model model) {
		QueryFilter filter = new QueryFilter(request);
		pageNum=pageNum==null? 1:pageNum;
		filter.setPage(pageNum);
		filter.setPageSize(18);
		Page<SupplierInfo> pages=supplierService.find(filter);
		model.addAttribute("pages", pages);
		String target=request.getParameter("show");
		if("dialog".equals(target)){
			return "supplierListDialog";
		}
		return "supplierList";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		SupplierInfo info = supplierService.get(SupplierInfo.class, id);
		model.addAttribute("info", info);
		return "supplierDetail";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(SupplierInfo supplier) {
		supplierService.save(supplier);
		Json json = new Json("成功", "200", "supplierList", "supplierList", null,
				null);
		return json;
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "GYS"+no);
		return "supplierAdd";
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Json update(SupplierInfo info,HttpSession session) {
		info.setUpdateDate(new Date());
		info.setUpdateUser((UserInfo) session.getAttribute("loginUser"));
		supplierService.update(info);
		Json json =new Json("更新成功","200","supplierList","supplierList",null,null);
		return json;
	}
}
