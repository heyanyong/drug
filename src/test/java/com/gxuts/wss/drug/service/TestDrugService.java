package com.gxuts.wss.drug.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.service.business.DrugService;
import com.gxuts.wss.dms.service.hr.SignService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestDrugService {
	@Autowired
	private DrugService drugService;
	
	@Test
	 public void testDrugUpdate(){
		DrugInfo drug=new DrugInfo(1);
		drug.setName("newName");
		drugService.update(drug);
		
	}
	//查列表
	@Test
	public void testAllDrug(){
		
	}
	 
} 
