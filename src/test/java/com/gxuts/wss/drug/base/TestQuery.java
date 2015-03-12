package com.gxuts.wss.drug.base;

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
public class TestQuery {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	
	@Before
	public void setUp(){
		
	}
	
	//属性查询
	@Test
	@Transactional
	public void test(){
		Session session=sessionFactory.getCurrentSession();
//		UserInfo user=(UserInfo) session.get(UserInfo.class, 9);
//		System.out.println(user.getId());
		 Criteria criteria =session.createCriteria(UserInfo.class);
//		 criteria.add(Restrictions.like("name", "%李%"));
		
//		 criteria.add(Restrictions.between("age", 50, 100));
//		 criteria.addOrder(Order.asc("name").ignoreCase());
		 System.out.println(criteria.list());
		 System.out.println(criteria.list().size());
	}
	//属性查询
	@Test
	@Transactional
	public void testQueryRelation(){
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria =session.createCriteria(UserInfo.class).add( Restrictions.eq("structure.id", 4 ) ) ;
		criteria.createCriteria("roles").add(Restrictions.like("name", "经理"));
		System.out.println(criteria.list());
		System.out.println(criteria.list().size());
	}
	//对象属性查询
	@Test
	@Transactional
	public void testQueryRelationInfo(){
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from UserInfo where 1=1");
		UserInfo user=(UserInfo) q.list().get(0);
		System.out.println(user);
	}
	//分组
	@Test
	@Transactional
	public void testSexGroup(){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select sex,count(*) from UserInfo u where u.age>10 group by sex ");
		List<Object[]> sexGroup=query.list();
		for (Object[] tt:sexGroup) {
			System.out.println(tt[0]+"--"+tt[1]);
		}
	}
		//HQL更新
		@Test
		@Transactional
		public void testUpdateByHql(){
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("update UserInfo set  no='NF001' where age<10");
			query.executeUpdate();
	}
		
		@Test
		public void getObject(){
			String hql="from UserInfo where name=? and no=?";
			String[] params={"李大嘴","NF0001"};
			UserInfo user=userService.getObject(hql, params);
			System.out.println(user);
		}
		
}
