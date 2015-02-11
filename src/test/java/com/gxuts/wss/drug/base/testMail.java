package com.gxuts.wss.drug.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class testMail {
	@Autowired
	SimpleMailMessage simpMail;
	@Autowired
	JavaMailSender sender;
	
	@Test
	public void testSendSimpleMail(){
		simpMail.setTo("596907468@qq.com");
    	simpMail.setSubject("主题5");
    	simpMail.setText("内容5");
    	sender.send(simpMail);
	}

}
