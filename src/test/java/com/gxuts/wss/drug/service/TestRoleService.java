package com.gxuts.wss.drug.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.service.hr.RoleService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestRoleService {
	@Autowired
	private RoleService roleService;
	
	@Test
	public void testSave(){
		RoleInfo role=new RoleInfo();
		role.setName("角色二");
		roleService.save(role);
	}
}
