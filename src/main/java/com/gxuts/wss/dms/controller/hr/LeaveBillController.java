package com.gxuts.wss.dms.controller.hr;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.gxuts.wss.dms.entity.hr.LeaveBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.hr.LeaveBillService;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowService;
import com.gxuts.wss.dms.util.DateUtil;
import com.gxuts.wss.dms.util.QueryFilter;
import com.gxuts.wss.dms.util.annotation.MethodName;

@Controller
@RequestMapping(value = "/leave")
public class LeaveBillController {
	@Autowired
	private LeaveBillService leaveBillService;
	@Autowired
	private FlowService flowService;
	@Autowired
	private UserService userService;

	@MethodName(name = "删除请假单")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		leaveBillService.delete(new LeaveBill(id));
		Json json = new Json("成功", "200", "leavePersList", "leavePersList", null, null);
		return json;
	}

	@MethodName(name = "请假单个人列表")
	@RequestMapping(value = "persList")
	public String getPersList(Integer pageNum,HttpServletRequest request){
		Integer userId=((UserInfo)request.getSession().getAttribute("loginUser")).getId();
		request.setAttribute("Q_t.createUser.id_eq_int",userId);
		QueryFilter filter = new QueryFilter(request);
		pageNum=pageNum==null? 1:pageNum;
		filter.setPage(pageNum); 
		filter.setPageSize(18);
		Page<LeaveBill> pages=leaveBillService.find(filter);
		request.setAttribute("pages", pages);
		return "leaveBillList";
	}
	@MethodName(name = "请假单部门列表")
	@RequestMapping(value = "deptList")
	public String getDeptList(Integer pageNum,HttpServletRequest request){
		Integer structureId=((UserInfo)request.getSession().getAttribute("loginUser")).getStructure().getId();
		request.setAttribute("Q_t.createUser.structure.id_eq_int",structureId);
		QueryFilter filter = new QueryFilter(request);
		pageNum=pageNum==null? 1:pageNum;
		filter.setPage(pageNum);
		filter.setPageSize(18);
		Page<LeaveBill> pages=leaveBillService.find(filter);
		request.setAttribute("pages", pages);
		return "leaveBillList";
	}
	@MethodName(name = "请假单汇总列表")
	@RequestMapping(value = "list")
	public String getList(Integer pageNum,HttpServletRequest request){
		QueryFilter filter = new QueryFilter(request);
		pageNum=pageNum==null? 1:pageNum;
		filter.setPage(pageNum);
		filter.setPageSize(18);
		Page<LeaveBill> pages=leaveBillService.find(filter);
		request.setAttribute("pages", pages);
		return "leaveBillList";
	}

	@MethodName(name = "编辑请假单")
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		LeaveBill info = leaveBillService.get(LeaveBill.class, id);
		if(info==null){
			return "sys/missing";
		}
		String pid = info.getFlowId();
		List<Object[]> comments = null;
		if (pid != null) {
			comments = flowService.getCommentByprocessInstance(pid);
			model.addAttribute("comments", comments);
		}
		model.addAttribute("info", info);
		return "leaveDetail";
	}

	@MethodName(name = "更新请假单")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Json update(LeaveBill info, HttpSession session) {
		info.setUpdateDate(new Date());
		info.setUpdateUser((UserInfo) session.getAttribute("loginUser"));
		leaveBillService.update(info);
		Json json = new Json("更新成功", "200", "leavePersList", "leavePersList", null,
				null);
		return json;
	}

	@MethodName(name = "保存请假单")
	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(LeaveBill leaveBill, HttpSession session) {
		if(leaveBill.getCadidate().getId()==null){
			return new Json("请选择工作交接人", "300",null, null, null, null);
		}
		leaveBill.setCreateDate(new Date());
		leaveBill.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		leaveBillService.save(leaveBill);
		return new Json("请假单保存成功", "200", "leavePersList", "leavePersList", "forward", "leave/persList");
	}

	@MethodName(name = "添加请假单")
	@RequestMapping(value = "add")
	public String add(Model m) {
		m.addAttribute("no",
				"HRQJ" + DateUtil.date2String(new Date(), "yyMMddHHmmss")
						+ new Random().nextInt(100));
		return "leaveBillAdd";
	}

	@RequestMapping(value = "/deal/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json deal(@PathVariable Integer id, HttpSession s) {
		UserInfo user = (UserInfo) s.getAttribute("loginUser");
		String processDefinitionKey = "leave";
		int roleGrade = userService.getMaxRole(user.getRoles()).getGrade();
		String businessKey = user.getStructure().getName() + "#"
				+ user.getName() + "(" + user.getNo() + ")#请假申请#leave#" + id
				+ "#" + "LeaveBill";
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("creater", user.getName()+"("+user.getNo()+")");
		variables.put("departmentId", user.getStructure().getId());
		variables.put("roleGrade", roleGrade);
		variables.put("assignee", null);
		variables.put("assigneeList", null);
		String  dealer = flowService.startProcess(processDefinitionKey, businessKey, variables);
		return new Json("提交成功,流程到达: "+dealer+"办理", "200", "leavePersList", "leavePersList", "forward", "leave/persList");
	}
	
}
