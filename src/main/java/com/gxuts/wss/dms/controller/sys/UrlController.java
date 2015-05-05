package com.gxuts.wss.dms.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.entity.sys.UrlInfo;
import com.gxuts.wss.dms.service.sys.UrlService;
import com.gxuts.wss.dms.util.annotation.MethodName;

@Controller
@RequestMapping(value = "/sysurl")
public class UrlController {
	@Autowired
	private UrlService urlService;
	
	@MethodName(name="保存一个URL")
	@RequestMapping(value = "/save")
	public String save(UrlInfo url) {
		urlService.save(url);
		return "sys/urlList";
	}
	@MethodName(name="删除一个URL")
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id) {
		urlService.delete(new UrlInfo(id));
		return "sys/urlList";
	}
	@MethodName(name="更新一个URL")
	@RequestMapping(value = "/update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json update(UrlInfo url) {
		urlService.update(url);
		return new Json();
	}
	@MethodName(name="查看一个URL")
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable Integer id,Model m) {
		UrlInfo url=urlService.get(UrlInfo.class, id);
		m.addAttribute("info", url);
		return "sys/urlDetail";
	}
	 
	@MethodName(name="URL列表")
	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String query(Model model,Integer pageNum){
		Page<UrlInfo> pages=urlService.query("from UrlInfo", null, pageNum, 17);
		model.addAttribute("pages", pages);
		return "sys/urlList";
	}
	 
}
