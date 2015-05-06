package com.gxuts.wss.drug.service.csrm;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.csrm.CustomerInfo;
import com.gxuts.wss.dms.entity.csrm.SupplierInfo;
import com.gxuts.wss.dms.service.csrm.SupplierService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestSupplierService {
	@Autowired
	private SupplierService supplierService;
	
	@Test
	public void testSave(){
		  SupplierInfo s1=new SupplierInfo();
		  s1.setCustomer(new CustomerInfo(1));
		  s1.setName("致远科技");
		  supplierService.save(s1);
	}
}
