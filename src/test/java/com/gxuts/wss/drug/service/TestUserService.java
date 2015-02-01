package com.gxuts.wss.drug.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.UserService;


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
		user.setName("管理员");
		user.setNo("NF002");
		user.setPassword("123");
		user.setBirthday(new Date());
//		user.setCreateUser(createUser);
		
		RoleInfo role=new RoleInfo();
		role.setId(2);
		Set<RoleInfo> roles=new HashSet();
		roles.add(role);
//		user.setRoles(roles);
		userService.save(user);
	}
	@Test
	public void testGet(){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("name", "管理员");
//		params.put("age", "1");
		UserInfo user=userService.get("from UserInfo u where 1=1 and  u.name=:name ",params);
		System.out.println(user.getId());
//		System.out.println(user.getRoles());
	}
	@Test
	public void getGetUser(){
		UserInfo user=userService.get(UserInfo.class,1);
		System.out.println(user.getStructure());
		System.out.println(user.getCreateUser());
//		System.out.println(user.getRoles());
	}
	
	@Test
	public void testUpdateByHql(){
		userService.executeHql("update UserInfo set no='NF000' where age<10");
	}
	
	@Test
	public void testLogin(){
		UserInfo user=new UserInfo();
		user.setNo("admin");
		user.setPassword("123");
		System.out.println(user);
		UserInfo u=userService.checkLogin(user);
		System.out.println(u);
	}
	@Test
	public void testGetByNo(){
		UserInfo user=userService.getByNo(UserInfo.class, "NF007");
		System.out.println(user.getName());
	}
}
