package com.gxuts.wss.dms.controller.hr;

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
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.hr.LeaveBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.LeaveBillService;

@Controller
@RequestMapping(value = "/leave")
public class LeaveBillController {
	@Autowired
	private LeaveBillService leaveBillService;
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		leaveBillService.delete(new LeaveBill(id));
		Json json = new Json("成功", "200", "leaveBillList", "leaveBillList", null,
				null);
		return json;
	}

	@RequestMapping(value = "list")
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<LeaveBill> pages = leaveBillService.query("from LeaveBill", null, null, null);
		model.addAttribute("pages", pages);
		return "leaveBillList";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		LeaveBill info = leaveBillService.get(LeaveBill.class, id);
		model.addAttribute("info", info);
		return "leaveBillDetail";
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Json update(LeaveBill info,HttpSession session) {
		info.setUpdateDate(new Date());
		info.setUpdateUser((UserInfo) session.getAttribute("loginUser"));
		leaveBillService.update(info);
		Json json =new Json("更新成功","200","leaveBillList","leaveBillList",null,null);
		return json;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(LeaveBill leaveBill,HttpSession session) {
		leaveBill.setCreateDate(new Date());
		leaveBill.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		System.out.println(leaveBill);
		leaveBill.setCadidate(null);
		leaveBillService.save(leaveBill);
		//return new Json("请假单录入","200",null,"userList","forwardConfirm","user/edit/1");
		return new Json("请假单录入","200",null,"userList","forward","leave/edit/1");
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "QJ"+no);
		return "leaveBillAdd";
	}
}
