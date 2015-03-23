package com.gxuts.wss.dms.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.ArticleInfo;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.manage.ArticleService;
import com.gxuts.wss.dms.service.process.FlowService;

@Controller
public class LoginController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private FlowService flowService;
	@RequestMapping(value="login")
	public String LoginPage(){
		return "login";
	}
	
	@RequestMapping(value="index")
	public String wecome(Model m,HttpSession session,String  pageNum){
		System.out.println(111111234);
		pageNum=pageNum==null? "0":pageNum;
		UserInfo user=(UserInfo) session.getAttribute("loginUser");
		Page<Object[]> page=flowService.queryPersonTask(user.getNo(), Integer.parseInt(pageNum), 10);
		m.addAttribute("taskList", page.getData());
		
		List<ArticleInfo> news = articleService.query(null, null, null, null).getData();
		m.addAttribute("news", news);
		return "index";
	}
	@RequestMapping(value="logout")
	public String LoginPage(HttpSession session){
		session.setAttribute("loginUser", null);
		return "redirect:/login.jsp";
	}
	@RequestMapping(value="/checkLogin", method=RequestMethod.POST)
	public String checkLogin(UserInfo user , HttpServletRequest request){
		UserInfo loginUser=userService.checkLogin(user);
		if(loginUser==null){
			return "redirect:/login.jsp?loginMsg='用户名或密码错误'";
		}else{
			request.getSession().setAttribute("loginUser", loginUser);
			return "redirect:/index.jsp";
		}
	}
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register( ){
	 
		return "redirect:/index.jsp";
	}
}
