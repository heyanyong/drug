package com.gxuts.wss.dms.controller.hr;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.hr.QuitBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.QuitService;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowService;
import com.gxuts.wss.dms.util.DateUtil;
import com.gxuts.wss.dms.util.MysqlUtil;
import com.gxuts.wss.dms.util.annotation.MethodName;

@Controller
@RequestMapping(value = "/quit")
public class QuitBillController {
	@Autowired
	private QuitService quitBillService;
	@Autowired
	private FlowService flowService;
	@Autowired
	private UserService userService;

	@MethodName(name = "删除离职申请单")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		quitBillService.delete(new QuitBill(id));
		Json json = new Json("成功", "200", "quitList", "quitList", null, null);
		return json;
	}

	@MethodName(name = "离职申请单列表")
	@RequestMapping(value = "list")
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<QuitBill> pages = quitBillService.query("from QuitBill", null,
				null, null);
		model.addAttribute("pages", pages);
		return "quitBillList";
	}

	@MethodName(name = "编辑离职申请单")
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		QuitBill bill = quitBillService.get(QuitBill.class, id);
		String pid = bill.getFlowId();
		List<Object[]> comments = null;
		if (pid != null) {
			comments = flowService.getCommentByprocessInstance(pid);
		}
		model.addAttribute("bill", bill);
		Object a;
		model.addAttribute("comments", comments);
		return "quitDetail";
	}

	@MethodName(name = "更新离职申请单")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Json update(QuitBill bill, HttpSession session) {
		bill.setUpdateDate(new Date());
		bill.setUpdateUser((UserInfo) session.getAttribute("loginUser"));
		quitBillService.update(bill);
		Json json = new Json("更新成功", "200", "quitList", "quitList", null,
				null);
		return json;
	}

	@MethodName(name = "保存离职申请单")
	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(QuitBill quitBill, HttpSession session) {
		quitBill.setCreateDate(new Date());
		quitBill.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		quitBillService.save(quitBill);
		// return new
		// Json("离职申请单录入","200",null,"userList","forwardConfirm","user/edit/1");
		return new Json("离职申请单保存成功", "200", "quitList", "quitList",
				"forward", "quit/list");
	}

	@MethodName(name = "添加离职申请单")
	@RequestMapping(value = "add")
	public String add(Model m) {
		m.addAttribute("no",
				"QJ" + DateUtil.date2String(new Date(), "yyMMddHHmmss")
						+ new Random().nextInt(100));
		return "quitBillAdd";
	}

	@RequestMapping(value = "/deal/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json deal(@PathVariable Integer id, HttpSession s) {
		UserInfo user = (UserInfo) s.getAttribute("loginUser");
		String processDefinitionKey = "quit";
		int roleGrade = userService.getMaxRole(user.getRoles()).getGrade();
		String businessKey = user.getStructure().getName() + "#"
				+ user.getName() + "#" + user.getNo() + "#离职申请申请#quit#" + id
				+ "#" + "QuitBill";
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("creater", user.getNo());
		variables.put("departmentId", user.getStructure().getId());
		variables.put("roleGrade", roleGrade);
		variables.put("assignee", null);
		variables.put("assigneeList", null);
		ProcessInstance pi = flowService.startProcess(processDefinitionKey,
				businessKey, variables);
		userService.executeHql("update QuitBill set status=2,flowId="
				+ pi.getId() + " where id=" + id);
		return new Json("提交办理成功", "200", "quitList", "quitList", null, null);
	}
}
