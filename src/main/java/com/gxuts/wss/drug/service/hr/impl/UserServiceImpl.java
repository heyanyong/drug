package com.gxuts.wss.drug.service.hr.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.drug.dao.hr.UserDao;
import com.gxuts.wss.drug.entity.UserInfo;
import com.gxuts.wss.drug.service.hr.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Serializable save(UserInfo user) {
		return userDao.save(user);
		
	}

	@Override
	public UserInfo get(Class<UserInfo> c, Serializable id) {
		return userDao.get(c,id);
	}

	@Override
	public UserInfo load(Class<UserInfo> c, Serializable id) {
		return userDao.load(c,id);
	}

	@Override
	public UserInfo get(String hql, Map<String, Object> params) {
		return userDao.get(hql, params);
	}

	@Override
	public UserInfo getObject(String hql, Object[] params) {
		 
		return userDao.getObject(hql, params);
	}

	@Override
	public int updateByHql(String hql) {
		return userDao.updateByHql(hql);
	}

	@Override
	public UserInfo checkLogin(UserInfo user) {
		return userDao.getObject("from UserInfo where no=? and password=?",new  String[]{user.getNo(),user.getPassword()} );
		
	}

}
