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
import com.gxuts.wss.dms.entity.business.PayBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.business.PayService;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/pay")
public class PayController {
	@Autowired
	private PayService payService;

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		payService.delete(new PayBill(id));
		Json json = new Json("成功", "200", "payList", "payList", null,null);
		return json;
	}

	@RequestMapping(value = "list")
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<PayBill> pages = payService.query(null, null, null, null);
		model.addAttribute("pages", pages);
		String target=request.getParameter("show");
		if("dialog".equals(target)){
			return "payListDialog";
		}
		return "payList";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		PayBill info = payService.get(PayBill.class, id);
		model.addAttribute("info", info);
		return "payDetail";
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Json update(PayBill info,HttpSession session) {
		info.setUpdateDate(new Date());
		info.setUpdateUser((UserInfo) session.getAttribute("loginUser"));
		payService.update(info);
		Json json =new Json("更新成功","200","payList","payList",null,null);
		return json;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(PayBill pay,HttpSession session) {
		pay.setCreateDate(new Date());
		pay.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		payService.save(pay);
		Json json = new Json("成功", "200", "payList", "payList", null,
				null);
		return json;
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "FK"+no);
		return "payAdd";
	}

}
