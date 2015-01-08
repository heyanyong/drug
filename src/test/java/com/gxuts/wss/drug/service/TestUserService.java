package com.gxuts.wss.drug.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.drug.entity.RoleInfo;
import com.gxuts.wss.drug.entity.StructureInfo;
import com.gxuts.wss.drug.entity.UserInfo;
import com.gxuts.wss.drug.service.hr.UserService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestUserService {
	@Autowired
	private UserService userService;
	@Test
	public void testSaveUser(){
		UserInfo user=new UserInfo();
		UserInfo createUser=new UserInfo();
		createUser.setId(10);
		
		user.setName("李大嘴");
		user.setCreateUser(createUser);
		RoleInfo role=new RoleInfo();
		role.setId(2);
		Set<RoleInfo> roles=new HashSet();
		roles.add(role);
		user.setRoles(roles);
		userService.save(user);
	}
	@Test
	public void testGet(){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("name", "李丽1");
		params.put("age", "1");
		UserInfo user=userService.get("from UserInfo u where 1=1 and  u.name=:name ",params);
		System.out.println(user.getId());
//		System.out.println(user.getRoles());
	}
	@Test
	public void getGetUser(){
		UserInfo user=userService.get(UserInfo.class,13);
		System.out.println(user.getStructure());
		System.out.println(user.getCreateUser());
//		System.out.println(user.getRoles());
	}
	
	@Test
	public void testUpdateByHql(){
		userService.updateByHql("update UserInfo set no='NF000' where age<10");
	}
}
