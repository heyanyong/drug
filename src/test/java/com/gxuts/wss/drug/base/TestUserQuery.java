package com.gxuts.wss.drug.base;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.UserService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestUserQuery {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	
	@Before
	public void setUp(){
		
	}
	
	 
		//本部门角色
		@Test
		@Transactional
		public void getByRole(){
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria =session.createCriteria(UserInfo.class).add( Restrictions.eq("structure.id", 5)) ;
			criteria.createCriteria("roles").add(Restrictions.like("name", "经理"));
			UserInfo user=(UserInfo) criteria.list().get(0);
			System.out.println(user);
			
		}
		
}
