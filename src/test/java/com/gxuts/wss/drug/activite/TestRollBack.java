package com.gxuts.wss.drug.activite;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.UserService;

@Transactional  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestRollBack {
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private UserService userService;
	
	@Test
	public void testDeploy(){
		UserInfo user=new UserInfo();
		user.setName("333");
		userService.save(user);
		Map<String, Object> params =new HashMap<String, Object>();
		params.put("name", "333");
		UserInfo u=userService.get("from UserInfo where name=:name", params);
		System.out.println(u);
	}

}
