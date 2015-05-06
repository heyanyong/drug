package com.gxuts.wss.drug.service.business;



import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.entity.business.PayBill;
import com.gxuts.wss.dms.entity.business.PayItem;
import com.gxuts.wss.dms.entity.csrm.CustomerInfo;
import com.gxuts.wss.dms.entity.csrm.SupplierInfo;
import com.gxuts.wss.dms.service.business.PayService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
//@Transactional
//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestPayService {
	@Autowired
	private PayService payService;
	
	@Test
	public void testSave(){
		PayBill pay=new PayBill();
		pay.setNo("FK1");
		pay.setCustomer(new CustomerInfo(1));
		pay.setSupplier(new SupplierInfo(1));
		List<PayItem> items=new ArrayList<PayItem>();
		items.add(new PayItem("i1"));
		items.add(new PayItem("i2"));
		items.add(new PayItem("i3"));
		
		pay.setItems(items);
		payService.save(pay);
	}
	@Test
	public void testGet(){
		PayBill pay=payService.get(PayBill.class, 3);
		System.out.println(pay.getItems().get(0).getNo());
		System.out.println(pay.getItems().get(1).getNo());
		System.out.println(pay.getItems().get(2).getNo());
		System.out.println(pay.getCustomer().getName());
		System.out.println(pay.getSupplier().getName());
	}
	@Test
	public void testUpdate(){
		PayBill pay=payService.get(PayBill.class, 3);
		pay.setName("update");
		pay.getItems().get(0).setNo("i111");
		System.out.println(pay.getItems().get(1).getNo());
		System.out.println(pay.getItems().get(2).getNo());
		System.out.println(pay.getCustomer().getName());
		System.out.println(pay.getSupplier().getName());
		 payService.update(pay);
	}
	@Test//删除关系 不删除子表
	public void tdelete(){
		payService.delete(new PayBill(2));
	}
	
}
