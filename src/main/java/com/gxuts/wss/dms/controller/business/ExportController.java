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
import com.gxuts.wss.dms.service.business.ExportService;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/export")
public class ExportController {
	@Autowired
	private ExportService exportService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		exportService.delete(new ExportBill(id));
		Json json = new Json("成功", "200", "exportList", "exportList", null,
				null);
		return json;
	}

	@RequestMapping(value = "list")
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<ExportBill> pages = exportService.query(null, null, null, null);
		model.addAttribute("pages", pages);
		return "exportList";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		ExportBill exportBill = exportService.get(ExportBill.class, id);
		model.addAttribute("exportBill", exportBill);
		return "exportDetail";
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(ExportBill exportBill) {
		System.out.println(exportBill);
		exportService.save(exportBill);
		Json json = new Json("成功", "200", "exportList", "exportList", null,
				null);
		return json;
	}

}
