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
import com.gxuts.wss.dms.entity.finance.ExpenseBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.finance.ExpenseService;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowService;
import com.gxuts.wss.dms.util.DateUtil;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/expense")
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private FlowService flowService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		expenseService.delete(new ExpenseBill(id));
		Json json = new Json("成功", "200", "expenseList", "expenseList", null,null);
		return json;
	}

	@RequestMapping(value = "list")
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<ExpenseBill> pages = expenseService.query("from ExpenseBill", null, null, null);
		model.addAttribute("pages", pages);
		return "expenseList";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		ExpenseBill info = expenseService.get(ExpenseBill.class, id);
		String pid=info.getFlowId();
		List<Object[]> comments=null;
		if(pid!=null){
			comments=flowService.getCommentByprocessInstance(pid);
		}
		model.addAttribute("info", info);
		model.addAttribute("comments", comments);
		return "expenseDetail";
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	@ResponseBody
	public Json update(ExpenseBill info,HttpSession session) {
		info.setUpdateDate(new Date());
		info.setUpdateUser((UserInfo) session.getAttribute("loginUser"));
		expenseService.update(info);
		Json json =new Json("更新成功","200","expenseList","expenseList",null,null);
		return json;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(ExpenseBill bill,HttpSession session) {
		bill.setCreateDate(new Date());
		bill.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		expenseService.save(bill);
		//return new Json("请假单录入","200",null,"userList","forwardConfirm","user/edit/1");
		return new Json("报销单保存成功","200","expenseList","expenseList","closeCurrent","expense/list");
	}
	@RequestMapping(value="add")
	public String add(Model m){
		
		m.addAttribute("no", "FYBX"+DateUtil.date2String(new Date(), "yyMMddHHmmss")+new Random().nextInt(100));
		return "expenseAdd";
	}
	@RequestMapping(value="/deal/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json deal(@PathVariable Integer id,HttpSession s){
		UserInfo user=(UserInfo) s.getAttribute("loginUser");
		String processDefinitionKey="expense";
		int roleGrade=userService.getMaxRole(user.getRoles()).getGrade();
		String businessKey=user.getStructure().getName()+"#"+user.getName()+"#"+
		user.getNo()+"#费用报销审批#expense#"+id+"#"+"ExpenseBill";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("creater", user.getNo());
		variables.put("departmentId", user.getStructure().getId());
		variables.put("roleGrade", roleGrade);
		variables.put("assignee", null);
		variables.put("assigneeList", null);	
		ProcessInstance pi= flowService.startProcess(processDefinitionKey, businessKey, variables);
		userService.executeHql("update ExpenseBill set status=2,flowId="+pi.getId()+" where id="+id);
		return new Json("提交办理成功","200","expenseList","expenseList",null,null);
	}
	
}
