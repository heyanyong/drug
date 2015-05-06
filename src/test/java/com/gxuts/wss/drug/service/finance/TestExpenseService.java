package com.gxuts.wss.drug.service.finance;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.csrm.DrugInfo;
import com.gxuts.wss.dms.entity.csrm.PurchaseBill;
import com.gxuts.wss.dms.entity.csrm.PurchaseContractBill;
import com.gxuts.wss.dms.entity.finance.ExpenseBill;
import com.gxuts.wss.dms.entity.finance.ExpenseItem;
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.csrm.DrugService;
import com.gxuts.wss.dms.service.csrm.PurchaseContractService;
import com.gxuts.wss.dms.service.finance.ExpenseService;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
@Transactional  
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestExpenseService {
	@Autowired
	private ExpenseService expenseService;
	@Test
	public void testSave() {
		ExpenseBill bill=new ExpenseBill();
		bill.setName("test");
		ExpenseItem item1=new ExpenseItem();
		item1.setMoney(10);
		item1.setStructure(new StructureInfo(10));
		item1.setName("电话费");
		item1.setNo("660201");
		List<ExpenseItem> items=new ArrayList<ExpenseItem>();
		items.add(item1);
		bill.setItems(items);
		Json json;
		System.out.println(json=expenseService.save(bill));
		assertEquals("200", json.getStatusCode());
	}
	@Ignore
	@Test
	public void get (){
		ExpenseBill bill=expenseService.get(ExpenseBill.class,1);
		System.out.println(bill.getItems().get(0).getName());
	}
	@Ignore
	@Test
	public void update (){
		ExpenseBill bill=expenseService.get(ExpenseBill.class,1);
		ExpenseItem it=bill.getItems().get(0);
		it.setName("交通费");
		expenseService.update(bill);
	}
	@Ignore
	@Test
	public void delete (){
		expenseService.delete(new ExpenseBill(1));
	}
	 
}
