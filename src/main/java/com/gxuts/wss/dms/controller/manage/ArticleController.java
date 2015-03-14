package com.gxuts.wss.dms.controller.manage;

import java.util.Date;
import java.util.List;

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
import com.gxuts.wss.dms.entity.business.CustomerInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.ArticleInfo;
import com.gxuts.wss.dms.service.manage.ArticleService;
import com.gxuts.wss.dms.service.hr.UserService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String getList(HttpServletRequest request, Integer currentPage,
			Integer row, Model model) {
		Page<ArticleInfo> pages = articleService.query(null, null, null, null);
		model.addAttribute("pages", pages);
		return "articleList";
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "ZX"+no);
		return "articleAdd";
	}
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json save(Model model,ArticleInfo article,HttpSession session){
		article.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		article.setCreateDate(new Date());
		articleService.save(article);
		return new Json();
	}
	@RequestMapping(value = "/view/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		ArticleInfo article = articleService.get(ArticleInfo.class, id);
		System.out.println(article);
		model.addAttribute("info", article);
		return "articleView";
	}
	@RequestMapping(value="update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json update(Model model,ArticleInfo article){
		System.out.println(article);
		articleService.update(article);
		return new Json();
	}
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json delete(Model model,ArticleInfo article){
		System.out.println(article);
		articleService.delete(article);
		return new Json();
	}
	
}
