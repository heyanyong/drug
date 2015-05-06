package com.gxuts.wss.dms.controller.csrm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.csrm.DrugInfo;
import com.gxuts.wss.dms.entity.csrm.PurchaseContractBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.csrm.PurchaseContractService;

 
@Controller
@RequestMapping(value = "/contract")
public class PurchaseContractController {
	@Autowired
	private PurchaseContractService purchaseContractService;

	@RequestMapping(value="list",method={RequestMethod.POST,RequestMethod.GET})
	public String query(Model model,String name,Integer pageNum){
		Page<PurchaseContractBill> pages=purchaseContractService.query("from PurchaseContractBill where 1=1", null, pageNum, 17);
		model.addAttribute("name", name);
		model.addAttribute("pages", pages);
		return "contractList";
	}
	@RequestMapping(value="add")
	public String add(Model m){
		long no=new Date().getTime();
		m.addAttribute("no", "HT"+no);
		return "contractAdd";
	}
	@RequestMapping(value = "/save",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Json save(PurchaseContractBill contract,HttpSession session) {
		contract.setCreateDate(new Date());
		contract.setCreateUser((UserInfo)session.getAttribute("loginUser"));
		Date nd=new Date();
		contract.setCreateDate(nd);
		int size=contract.getDrugs().size();
		List<DrugInfo> list=contract.getDrugs();
		for (int i = 0; i < size; i++) {
			list.get(i).setCreateDate(nd);
			list.get(i).setContract(contract);
		}
		purchaseContractService.save(contract);
		Json json =new Json("成功","200","contractList","contractList",null,null);
		return json;
	}
	@RequestMapping(value = "/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Json delete(@PathVariable Integer id) {
		purchaseContractService.delete(new PurchaseContractBill(id));
//		Json json =new Json("测试","200",null,"userList","forwardConfirm","user/edit/1");
		Json json =new Json("成功","200","contractList","contractList",null,null);
		return json;
	}
	@RequestMapping(value="/fromPurchase")
	public String fromPurchase(Integer purchaseId,Model model,HttpSession session){
		String no="HT"+new Date().getTime();
		PurchaseContractBill info=purchaseContractService.fromPurchase(purchaseId);
		info.setNo(no);
		info.setCreateUser((UserInfo)session.getAttribute("loginUser"));
		model.addAttribute("info", info);
		return "contractDetail";
		
	}
	 


	 
}
