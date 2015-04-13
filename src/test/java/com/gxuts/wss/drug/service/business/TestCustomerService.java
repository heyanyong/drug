package com.gxuts.wss.drug.service.business;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.business.CustomerInfo;
import com.gxuts.wss.dms.service.business.CustomerService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestCustomerService {
	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testSave(){
		  CustomerInfo customer=new CustomerInfo();
		  customer.setName("清华同方2");
//		  ArrayList<SupplierInfo> suppliers=new ArrayList<SupplierInfo>();
//		  suppliers.add(new SupplierInfo(1));
		  customerService.save(customer);
	}
	@Test
	public void testGet(){
		CustomerInfo into=customerService.get(CustomerInfo.class, 2);
		System.out.println(into);
	}
}
