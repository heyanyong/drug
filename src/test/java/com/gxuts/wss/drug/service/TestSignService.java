package com.gxuts.wss.drug.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.service.hr.SignService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestSignService {
	@Autowired
	private SignService signService;
	
	@Test
	public void testSave() throws ParseException{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date recordDate=df.parse("2015-01-08");
		System.out.println( recordDate);
		Date signDate = null;
		signService.save("NF007", recordDate, signDate);
	}
}
