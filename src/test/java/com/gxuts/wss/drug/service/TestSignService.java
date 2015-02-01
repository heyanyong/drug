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
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.service.hr.SignService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestSignService {
	@Autowired
	private SignService signService;
	
	@Test
	public void testSave() throws ParseException{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date recordDate=df.parse("2015-01-4");
		Date signDate = df2.parse("2015-01-30 8:11:00");
		System.out.println(signService.save("NF002", recordDate, signDate));
	}
	@Test
	public void testUpdate(){
		SignInfo sign=signService.get(SignInfo.class, 5);
		sign.setRemark("1213");
		signService.update(sign);
	}
}
