package com.gxuts.wss.dms.controller.sys;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.ArticleInfo;
import com.gxuts.wss.dms.entity.sys.UrlInfo;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.service.manage.ArticleService;
import com.gxuts.wss.dms.service.process.FlowService;
import com.gxuts.wss.dms.util.annotation.MethodName;

@Controller
public class LoginController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private FlowService flowService;
	@MethodName(name="访问主页")
	@RequestMapping(value="index")
	public String index(Model m,HttpSession session,String  pageNum){
		//news
		System.out.println("++++request index++++ ");
		Page<ArticleInfo> pages = articleService.query(null, null, null, 5);
		List<ArticleInfo> news=pages.getData();
		m.addAttribute("news", news);
		
		//static
		String countData="[ 1149422, 551315, 172095, 166565, 53329, 18060, 8074, 1941,1393, 1104, 2110 ]";
		String countItem="[ \"%%.%% – Firefox\", \"%%.%% – IExplorer\", \"%%.%% – Chrome\","
				+ "\"%%.%% – Safari\", \"%%.%% – Opera\", \"%%.%% – Mozilla\",\"%%.%% – Mozilla\", "
				+ "\"%%.%% – Opera Mini\", \"%%.%% – SeaMonkey\",\"%%.%% – Camino\", \"%%.%% – Other\" ]";
		m.addAttribute("countData", countData);
		m.addAttribute("countItem", countItem);
		return "welcome";
	}
	@RequestMapping(value="login")
	public String LoginPage(){
		return "login";
	}
	
	@RequestMapping(value="logout")
	public String Logout(HttpSession session){
		session.setAttribute("loginUser", null);
		return "redirect:/login.jsp";
	}
	@MethodName(name="登录验证")
	@RequestMapping(value="/checkLogin", method=RequestMethod.POST)
	public String checkLogin(UserInfo user , HttpServletRequest request){
		UserInfo loginUser=userService.checkLogin(user);
		if(loginUser==null){
			return "redirect:/login.jsp?loginMsg=1";
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", loginUser);
			List<RoleInfo> roles=loginUser.getRoles();
			List<UrlInfo> permisions=new ArrayList<UrlInfo>();
			for(RoleInfo role:roles){
				permisions.addAll(role.getUrls());
			}
			session.setAttribute("permisions", permisions);
			return "redirect:/index";
		}
	}
}
