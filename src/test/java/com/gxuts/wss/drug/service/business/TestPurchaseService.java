package com.gxuts.wss.drug.service.business;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.service.business.DrugService;
import com.gxuts.wss.dms.service.business.PurchaseService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
//@Transactional  
//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestPurchaseService {
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private DrugService drugService;
 
	@Test
	public void testSave(){
		 PurchaseBill purchase=new PurchaseBill();
		 purchase.setName("采购需求");
		 List<DrugInfo> drugs=new ArrayList<DrugInfo>();
		 DrugInfo drug1=new DrugInfo();
		 DrugInfo drug2=new DrugInfo();
		 drug1.setName("感冒1");
		 drug2.setName("感冒2");
		 drug1.setRequestNumber(100);
		 drug2.setRequestNumber(100);
		 drugs.add(drug1);
		 drugs.add(drug2);
		 purchase.setDrugs(drugs);   
		 purchase.setId(44);//被忽略
		 purchaseService.save(purchase);
	}
	@Test
	public void testGet(){
		PurchaseBill p=purchaseService.get(PurchaseBill.class, 1);
		List<DrugInfo> drugs=p.getDrugs();
		System.out.println(p);
		for (DrugInfo d:drugs) {
			System.out.println(d);
		}
	}
	@Test
	public void testUpdate(){
		PurchaseBill p=purchaseService.get(PurchaseBill.class, 1);
		DrugInfo d=p.getDrugs().get(0);
		d.setName("updateName");
		purchaseService.update(p);
	}
	
	@Test
	public void testDelete(){
		 PurchaseBill purchase=new PurchaseBill();
		 purchase.setId(1);
		 purchaseService.delete(purchase);
	}
	@Test
	public void  getList(){
		purchaseService.query(null, null, null, null);
	}
	
 
}
