package com.gxuts.wss.drug.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.business.DrugService;
import com.gxuts.wss.dms.service.business.PurchaseContractService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TestContractService {
	@Autowired
	private PurchaseContractService purchaseContractService;
	@Autowired
	private DrugService drugService;
	@Test
	public void testSave() {
		PurchaseContractBill contract = new PurchaseContractBill();
		contract.setName("合1同");
		List<DrugInfo> drugs=new ArrayList<DrugInfo>();
		DrugInfo drug1=new DrugInfo();
		drug1.setName("药品一");
		drug1.setContract(contract);
		drugs.add(drug1);
		UserInfo user=new UserInfo();
		user.setId(122);
		contract.setCreateUser(user);
		contract.setDrugs(drugs);
		purchaseContractService.save(contract);

	}
	
	@Test
	public void testGet(){
		PurchaseContractBill contract=purchaseContractService.get(PurchaseContractBill.class, 1);
		List<DrugInfo> drugs=contract.getDrugs();
		System.out.println(contract);
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
		purchaseContractService.delete(new PurchaseContractBill(8));
	}
	
	@Test
	public void testGetContractByPurchase(){
		PurchaseContractBill contract=purchaseContractService.fromPurchase(2);
		System.out.println(contract);
	}
	
	
}
