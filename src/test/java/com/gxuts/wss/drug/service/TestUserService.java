package com.gxuts.wss.drug.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.UserService;
import com.gxuts.wss.dms.util.QueryFilter;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestUserService {
	@Autowired
	private UserService userService;
	@Test
	public void testSaveUser(){
		UserInfo user=new UserInfo();
		user.setName("员工一");
		user.setNo("NF001");
		
		RoleInfo role=new RoleInfo();
		role.setId(1);
		RoleInfo role2=new RoleInfo();
		role2.setId(6);
		List<RoleInfo> roles=new ArrayList<RoleInfo>();
		roles.add(role);
		roles.add(role2);
		user.setRoles(roles);
		userService.save(user);
	}
	@Test
	public void testGet(){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("name", "员工一");
//		params.put("age", "1");
		UserInfo user=userService.get("from UserInfo u where 1=1 and  u.name=:name ",params);
		System.out.println(user);
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
		userService.executeHql("update LeaveBill set status=2,flowId=2 where id="+5);
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
	//查领导
	@Test
	public void getMaxRoleGrade(){
		List<RoleInfo> roles=null;
		RoleInfo grade= userService.getMaxRole(roles);
	}
	//查领导
	@Test
	public void testFind(){
		HttpServletRequest q=new MockHttpServletRequest();
		q.setAttribute("Q_t.name_like", "admin");
		QueryFilter filter=new QueryFilter(q);
		Page<UserInfo> p=userService.find(filter);
		System.out.println(p);
	}
	
	
	
}
