package com.gxuts.wss.dms.controller.finance;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.Json;
import com.gxuts.wss.dms.entity.business.ExportBill;
import com.gxuts.wss.dms.entity.business.CustomerInfo;
import com.gxuts.wss.dms.entity.finance.ExpenseBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.business.ExportService;
import com.gxuts.wss.dms.service.business.CustomerService;

import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/expense")
public class ExpenseController {
	 

}
