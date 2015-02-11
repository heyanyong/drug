package com.gxuts.wss.drug.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.service.hr.SignService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestRoleService {
	@Autowired
	private SignService signService;
	
	@Test
	public void testSave(){
		String userNo="NF003";
		Date recordDate=new Date();
		Date signDate=new Date();
		signService.save(userNo, recordDate, signDate);
		  
	}
}
