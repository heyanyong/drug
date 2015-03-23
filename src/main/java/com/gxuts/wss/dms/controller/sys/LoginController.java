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
	@RequestMapping(value="index")
	public String index(Model m){
		System.out.println("++++request index++++ ");
		Page<ArticleInfo> pages = articleService.query(null, null, null, null);
		List<ArticleInfo> news=pages.getData();
		m.addAttribute("news", news);
		return "welcome";
	}
	@RequestMapping(value="login")
	public String LoginPage(){
		return "login";
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
			return "redirect:/index";
		}
	}
}
