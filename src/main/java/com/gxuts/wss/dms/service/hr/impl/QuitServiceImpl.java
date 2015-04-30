package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.hr.QuitDao;
import com.gxuts.wss.dms.entity.hr.QuitBill;
import com.gxuts.wss.dms.service.hr.QuitService;
@Service("quitService")
@Transactional
public class QuitServiceImpl implements QuitService {
	@Autowired
	private QuitDao quitDao;

	@Override
	public Serializable save(QuitBill quit) {
		return quitDao.save(quit);
		
	}

	@Override
	public QuitBill get(Class<QuitBill> c, Serializable id) {
		 
		return quitDao.get(c, id);
	}

	@Override
	public void delete(QuitBill quit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(QuitBill quit) {
		quitDao.update(quit);
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
	public List<QuitBill> queryAll(Class<QuitBill> c) {
		return quitDao.queryAll(c);
	}

	@Override
	public QuitBill load(Class<QuitBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuitBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuitBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<QuitBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return quitDao.query(hql, params, currentPage, rows);
	}


}
