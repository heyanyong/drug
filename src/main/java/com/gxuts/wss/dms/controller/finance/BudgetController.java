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
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.finance.BudgetInfo;
import com.gxuts.wss.dms.entity.finance.BudgetUpdateBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.finance.BudgetService;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowService;
import com.gxuts.wss.dms.util.DateUtil;
import com.gxuts.wss.dms.util.annotation.MethodName;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/budget")
public class BudgetController {
	@Autowired
	private BudgetService budgetService;
	@Autowired
	private FlowService flowService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		budgetService.delete(new BudgetInfo(id));
		Json json = new Json("成功", "200", "budgetList", "budgetList", null,null);
		return json;
	}
	@MethodName(name="列表")
	@RequestMapping(value = "list")
	public String getList() {
		return "budgetList";
	}
	@MethodName(name="部门预算明细")
	@RequestMapping(value = "/detail/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Page<BudgetInfo> pages = budgetService.query("from BudgetInfo", null, null, null);
		model.addAttribute("pages", pages);
		return "budgetDetail";
	}
	@RequestMapping(value = "/saveUpdate")
	@ResponseBody
	public Json saveUpdate(BudgetUpdateBill bill,HttpSession session) {
		System.out.println(bill.getBudgets());
		//Json json =new Json("更新成功","200","budgetList","budgetList",null,null);
		return null;
	}

	@RequestMapping(value="add")
	public String add(Model m){
		
		m.addAttribute("no", "FYBX"+DateUtil.date2String(new Date(), "yyMMddHHmmss")+new Random().nextInt(100));
		return "budgetAdd";
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
