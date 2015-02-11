package com.gxuts.wss.drug.service;

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
		 drug1.setName("感冒");
		 drug2.setName("感冒2");
		 drug1.setRequestNumber(100);
		 drug2.setRequestNumber(100);
		 drugs.add(drug1);
		 drugs.add(drug2);
		 purchase.setDrugs(drugs);    
		 purchaseService.save(purchase);
	}
	@Test
	public void testGet(){
		PurchaseBill contract=purchaseService.get(PurchaseBill.class, 7);
		List<DrugInfo> drugs=contract.getDrugs();
		for (DrugInfo d:drugs) {
			System.out.println(d);
		}
	}
	@Test
	public void testDelete(){
		 PurchaseBill purchase=new PurchaseBill();
		 purchase.setId(9);
		 purchaseService.delete(purchase);
	}
	
	@Test
	public void getPurchaseByDrug(){
		DrugInfo drug=drugService.get(DrugInfo.class, 5);
		System.out.println(drug);
	}
	//f
	@Test
	public void purchaseToContract(){
		purchaseService.purcharseToContract(10);
	}
}
