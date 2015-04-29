package com.gxuts.wss.drug.service.hr;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.entity.sys.UrlInfo;
import com.gxuts.wss.dms.service.hr.RoleService;
import com.gxuts.wss.dms.service.hr.SignService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestRoleService {
	@Autowired
	private RoleService roleService;
	
	@Test
	public void testSave(){
		  
	}
	@Test
	public void testUrl(){
		List obj=roleService.queryUrlAll(UrlInfo.class);
		System.out.println(obj);
		
	}
}
