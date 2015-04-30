package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.hr.SignExceptionDao;
import com.gxuts.wss.dms.entity.hr.SignExceptionBill;
import com.gxuts.wss.dms.service.hr.SignExceptionService;
@Service("signExceptionService")
@Transactional
public class SignExceptionServiceImpl implements SignExceptionService {
	@Autowired
	private SignExceptionDao signExceptionDao;

	@Override
	public Serializable save(SignExceptionBill signException) {
		return signExceptionDao.save(signException);
		
	}

	@Override
	public SignExceptionBill get(Class<SignExceptionBill> c, Serializable id) {
		 
		return signExceptionDao.get(c, id);
	}

	@Override
	public void delete(SignExceptionBill signException) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SignExceptionBill signException) {
		signExceptionDao.update(signException);
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
	public List<SignExceptionBill> queryAll(Class<SignExceptionBill> c) {
		return signExceptionDao.queryAll(c);
	}

	@Override
	public SignExceptionBill load(Class<SignExceptionBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignExceptionBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SignExceptionBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SignExceptionBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return signExceptionDao.query(hql, params, currentPage, rows);
	}


}
