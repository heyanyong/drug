package com.gxuts.wss.dms.controller.finance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.finance.BudgetInfo;
import com.gxuts.wss.dms.entity.finance.BudgetBill;
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.finance.BudgetBillService;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowService;
import com.gxuts.wss.dms.util.DateUtil;
import com.gxuts.wss.dms.util.annotation.MethodName;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/budget")
public class BudgetController {
	@Autowired
	private BudgetBillService budgetBillService;
	@Autowired
	private FlowService flowService;
	@Autowired
	private UserService userService;
	
	@MethodName(name="删减一条部门预算科目")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		Json json = new Json("成功", "200", "budgetList", "budgetList", null,null);
		return json;
	}
	@MethodName(name="进入预算维护列表")
	@RequestMapping(value = "list")
	public String getList() {
		return "budgetList";
	}
	@MethodName(name="打开部门预算明细")
	@RequestMapping(value = "/detail/{sid}")
	public String edit(@PathVariable Integer sid, Model model) {
		BudgetBill info = budgetBillService.getObject("from BudgetBill where structure.id="+sid, null);
		model.addAttribute("structrueId", sid);
		model.addAttribute("info", info);
		return "budgetDetail";
	}
	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public Json saveOrUpdate(BudgetBill bill) {
		System.out.println(bill);
	    budgetBillService.saveOrUpdate(bill);
		return new Json("更新成功","200","budgetList","budgetList",null,null);
	}

	@RequestMapping(value="/deal/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json deal(@PathVariable Integer id,HttpSession s){
		UserInfo user=(UserInfo) s.getAttribute("loginUser");
		String processDefinitionKey="budget";
		int roleGrade=userService.getMaxRole(user.getRoles()).getGrade();
		String businessKey=user.getStructure().getName()+"#"+user.getName()+"#"+
		user.getNo()+"#费用报销审批#budget#"+id+"#"+"BudgetInfo";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("creater", user.getNo());
		variables.put("departmentId", user.getStructure().getId());
		variables.put("roleGrade", roleGrade);
		variables.put("assignee", null);
		variables.put("assigneeList", null);	
		ProcessInstance pi= flowService.startProcess(processDefinitionKey, businessKey, variables);
		userService.executeHql("update BudgetInfo set status=2,flowId="+pi.getId()+" where id="+id);
		return new Json("提交办理成功","200","budgetList","budgetList",null,null);
	}
	
}
