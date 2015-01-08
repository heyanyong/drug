package com.gxuts.wss.drug.base;

import javax.sound.midi.Track;

import net.sf.ehcache.search.expression.Between;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.drug.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestQuery {
	@Autowired
	private SessionFactory sessionFactory;
	
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
		Criteria criteria =session.createCriteria(UserInfo.class);
		 //关联关系查
		 criteria.createCriteria("roles").add(Restrictions.like("name", "角色一"));
		System.out.println(criteria.list());
		System.out.println(criteria.list().size());
	}
}
