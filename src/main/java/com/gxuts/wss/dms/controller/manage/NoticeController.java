package com.gxuts.wss.dms.controller.manage;

import java.util.Date;

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
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.NoticeInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.manage.NoticeService;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String getList(HttpSession session, Integer currentPage,
			Integer row, Model model) {
		UserInfo user= (UserInfo)session.getAttribute("loginUser");
		Page<NoticeInfo> pages = noticeService.query("from NoticeInfo where isAvailable=true and createUser.id="+user.getId(), null, null, null);
		model.addAttribute("pages", pages);
		return "noticeListDialog";
	}
	@RequestMapping(value="save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json save(Model model,NoticeInfo notice){
		notice.setCreateDate(new Date());
		notice.setIsAvailable(true);
		noticeService.save(notice);
		return new Json(null,"200","noticeListDialog","noticeListDialog","reloadDialog","noticeListDialog");
	}
	@RequestMapping(value="ignore",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json ignore(String id){
		noticeService.executeHql("update NoticeInfo set isAvailable=false  where id="+id);
		return new Json(null,"200","noticeListDialog","noticeListDialog","reloadDialog","noticeListDialog");
	}
	
}
