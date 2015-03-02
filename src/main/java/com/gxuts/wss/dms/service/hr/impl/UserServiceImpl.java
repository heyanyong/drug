package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import liquibase.util.MD5Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.hr.UserDao;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.UserService;

 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Serializable save(UserInfo user) {
		user.setPassword(MD5Util.computeMD5("123"));
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
	public UserInfo checkLogin(UserInfo user) {
		user.setPassword(MD5Util.computeMD5(user.getPassword()));
		return userDao.getObject("from UserInfo where no=? and password=?",new  String[]{user.getNo(),user.getPassword()} );
	}

	@Override
	public List<UserInfo> queryAll(Class<UserInfo> c) {
		return userDao.queryAll(c);
	}

	@Override
	public int executeHql(String hql) {
		return userDao.executeHql(hql);
	}

	@Override
	public Page<UserInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return userDao.query(hql, params, currentPage, rows);
	}

	@Override
	public UserInfo getByNo(Class<UserInfo> c, String no) {
		return userDao.getByNo(c, no);
	}

	@Override
	public UserInfo getByHql(String hql) {
		return userDao.getByHql(hql);
	}

	@Override
	public void delete(UserInfo user) {
		userDao.delete(user);
	}

	@Override
	public void update(UserInfo user) {
		userDao.update(user);
	}

	 

}
