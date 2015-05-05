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
import com.gxuts.wss.dms.entity.finance.SubjectInfo;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.finance.SubjectService;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.process.FlowService;
import com.gxuts.wss.dms.util.DateUtil;
import com.gxuts.wss.dms.util.annotation.MethodName;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private FlowService flowService;
	@Autowired
	private UserService userService;
	
	@MethodName(name="保存一个科目")
	@RequestMapping(value = "/save")
	@ResponseBody
	public Json save(SubjectInfo subject,HttpSession session) {
		subject.setCreateDate(new Date());
		subject.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		subjectService.save(subject);
		Json json = new Json("成功", "200", "subjectList", "subjectList", "forward","subject/list");
		return json;
	}
	
	@MethodName(name="删减一条预算科目")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		subjectService.delete(new SubjectInfo(id));
		Json json = new Json("成功", "200", "subjectList", "subjectList", null,null);
		return json;
	}
	@MethodName(name="进入科目维护列表")
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String query(Model model,String name,Integer pageNum,HttpServletRequest request){
		name=(name==null)? "%":name;
		Page<SubjectInfo> pages=subjectService.query("from SubjectInfo where name like '%"+name+"%'", null, pageNum, 17);
		model.addAttribute("pages", pages);
		String target=request.getParameter("show");
		if("dialog".equals(target)){
			return "subjectListDialog";
		}
		return "subjectList";
	}

	@RequestMapping(value="/deal/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Json deal(@PathVariable Integer id,HttpSession s){
		UserInfo user=(UserInfo) s.getAttribute("loginUser");
		String processDefinitionKey="subject";
		int roleGrade=userService.getMaxRole(user.getRoles()).getGrade();
		String businessKey=user.getStructure().getName()+"#"+user.getName()+"#"+
		user.getNo()+"#费用报销审批#subject#"+id+"#"+"BudgetInfo";
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("creater", user.getNo());
		variables.put("departmentId", user.getStructure().getId());
		variables.put("roleGrade", roleGrade);
		variables.put("assignee", null);
		variables.put("assigneeList", null);	
		ProcessInstance pi= flowService.startProcess(processDefinitionKey, businessKey, variables);
		userService.executeHql("update BudgetInfo set status=2,flowId="+pi.getId()+" where id="+id);
		return new Json("提交办理成功","200","subjectList","subjectList",null,null);
	}
	
}
