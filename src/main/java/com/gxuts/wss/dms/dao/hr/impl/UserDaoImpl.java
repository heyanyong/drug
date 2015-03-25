package com.gxuts.wss.dms.dao.hr.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.hr.UserDao;
import com.gxuts.wss.dms.entity.hr.UserInfo;
@Repository("userDao")
public class UserDaoImpl extends BaseDao<UserInfo> implements UserDao{

	@Override
	public UserInfo departmentOneRole(int departmentId,String roleName) {
		Criteria criteria =this.getSession().createCriteria(UserInfo.class).add( Restrictions.eq("structure.id", departmentId)) ;
		criteria.createCriteria("roles").add(Restrictions.like("name", roleName));
		List<UserInfo> list=criteria.list();
		return (list!=null&&list.size()>0)? list.get(0):null;  
	}

	@Override
	public List<UserInfo> manyByRole(String roleName) {
		Criteria criteria =this.getSession().createCriteria(UserInfo.class) ;
		criteria.createCriteria("roles").add(Restrictions.like("name", roleName));
		return criteria.list();
	}



}
