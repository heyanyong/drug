package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.hr.SignDao;
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.service.hr.SignService;
@Service("signService")
@Transactional
public class SignServiceImpl implements SignService {
	@Autowired
	private SignDao signDao;

	@Override
	public Serializable save(SignInfo sign) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignInfo get(Class<SignInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SignInfo sign) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SignInfo sign) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int executeHql(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SignInfo> queryAll(Class<SignInfo> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignInfo load(Class<SignInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignInfo get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignInfo getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SignInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
