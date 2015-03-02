package com.gxuts.wss.dms.controller.business;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.business.ExportBill;
import com.gxuts.wss.dms.entity.business.SupplierInfo;
import com.gxuts.wss.dms.service.business.ExportService;
import com.gxuts.wss.dms.service.business.SupplierService;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/supplier")
public class CustomerController {
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
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<SupplierInfo> pages = supplierService.query(null, null, null, null);
		model.addAttribute("pages", pages);
		return "supplierList";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		SupplierInfo supplier = supplierService.get(SupplierInfo.class, id);
		model.addAttribute("supplier", supplier);
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

}
