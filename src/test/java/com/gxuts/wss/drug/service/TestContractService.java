package com.gxuts.wss.drug.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.service.business.PurchaseContractService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TestContractService {
	@Autowired
	private PurchaseContractService purchaseContractService;

	@Test
	public void testSave() {
		PurchaseContractBill contract = new PurchaseContractBill();
		contract.setName("test");
		List<DrugInfo> drugs=new ArrayList<DrugInfo>();
		DrugInfo drug1=new DrugInfo();
		drug1.setName("drugName1");
		drugs.add(drug1);
		contract.setDrugs(drugs);
		purchaseContractService.save(contract);

	}
	
	@Test
	public void testGet(){
		PurchaseContractBill contract=purchaseContractService.get(PurchaseContractBill.class, 34);
		List<DrugInfo> drugs=contract.getDrugs();
		for (DrugInfo d:drugs) {
			System.out.println(d);
		}
	}
	@Test
	public void testUpdate(){
		PurchaseContractBill contract=purchaseContractService.get(PurchaseContractBill.class, 4);
		contract.setName("con");
		DrugInfo drug=contract.getDrugs().get(0);
		drug.setName("name22");
		purchaseContractService.update(contract);
		
	}
	@Test
	public void testDelete(){
		PurchaseContractBill contract=new PurchaseContractBill();
		contract.setId(34);
		purchaseContractService.delete(contract);
	}
	
	@Test
	public void testGetContractByPurchase(){
		PurchaseContractBill contract=purchaseContractService.fromPurchase(16);
		System.out.println(contract);
	}
}
