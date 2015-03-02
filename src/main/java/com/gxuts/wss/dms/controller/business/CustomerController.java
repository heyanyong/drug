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
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.business.ExportBill;
import com.gxuts.wss.dms.entity.business.CustomerInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.business.ExportService;
import com.gxuts.wss.dms.service.business.CustomerService;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		customerService.delete(new CustomerInfo(id));
		Json json = new Json("成功", "200", "customerList", "customerList", null,
				null);
		return json;
	}

	@RequestMapping(value = "list")
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<CustomerInfo> pages = customerService.query(null, null, null, null);
		model.addAttribute("pages", pages);
		return "customerList";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		CustomerInfo customer = customerService.get(CustomerInfo.class, id);
		model.addAttribute("customer", customer);
		return "customerDetail";
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Json update(CustomerInfo info,HttpSession session) {
		info.setUpdateDate(new Date());
		info.setUpdateUser((UserInfo) session.getAttribute("loginUser"));
		customerService.update(info);
		Json json =new Json("更新成功","200","customerList","customerList",null,null);
		return json;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(CustomerInfo customer,HttpSession session) {
		customer.setCreateDate(new Date());
		customer.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		customerService.save(customer);
		Json json = new Json("成功", "200", "customerList", "customerList", null,
				null);
		return json;
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "KH"+no);
		return "customerAdd";
	}

}
