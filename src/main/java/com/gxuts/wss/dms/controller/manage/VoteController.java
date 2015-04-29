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
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.VoteInfo;
import com.gxuts.wss.dms.service.manage.VoteService;
import com.gxuts.wss.dms.util.QueryFilter;

@Controller
@RequestMapping(value = "/vote")
public class VoteController {
	@Autowired
	private VoteService voteService;
	
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String find(Model model,Integer pageNum,HttpServletRequest request){
		QueryFilter filter = new QueryFilter(request);
		pageNum=pageNum==null? 1:pageNum;
		filter.setPage(pageNum);
		filter.setPageSize(18);
		Page<VoteInfo> pages=voteService.find(filter);
		model.addAttribute("pages", pages);
		return "voteList";
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "ZX"+no);
		return "voteAdd";
	}
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json save(Model model,VoteInfo vote,HttpSession session){
		vote.setCreateUser((UserInfo) session.getAttribute("loginUser"));
		vote.setCreateDate(new Date());
		voteService.save(vote);
		return new Json();
	}
	@RequestMapping(value = "/view/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		VoteInfo vote = voteService.get(VoteInfo.class, id);
		model.addAttribute("info", vote);
		return "voteView";
	}
	@RequestMapping(value="update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json update(Model model,VoteInfo vote){
		System.out.println(vote);
		voteService.update(vote);
		return new Json();
	}
	@RequestMapping(value="delete",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json delete(Model model,VoteInfo vote){
		System.out.println(vote);
		voteService.delete(vote);
		return new Json();
	}
	
}
