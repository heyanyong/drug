package com.gxuts.wss.dms.controller.sys;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.entity.sys.ControllerLog;
import com.gxuts.wss.dms.service.sys.ControllerLogService;


/**
 * ControllerLog控制器
 *
 */
@Controller
@RequestMapping("/LogController")
public class ControllerLogController {

	 @Autowired
	 private ControllerLogService controllerLogService ;

	@RequestMapping("/save")
	@ResponseBody
	public void  save(ControllerLog controllerLog) {
		controllerLogService.save(controllerLog);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public void delete(Long id, HttpServletRequest request) {
	}

	@RequestMapping("/update")
	@ResponseBody
	public void update(ControllerLog controllerLog) {
	}

	@RequestMapping("/get")
	@ResponseBody
	public void get(Long id, HttpServletRequest request) {
	}

	@RequestMapping("/find")
	@ResponseBody
	public void find(HttpServletRequest request) {
	}

}
