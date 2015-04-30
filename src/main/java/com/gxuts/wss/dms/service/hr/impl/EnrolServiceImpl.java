package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.hr.EnrolDao;
import com.gxuts.wss.dms.entity.hr.EnrolBill;
import com.gxuts.wss.dms.service.hr.EnrolService;
@Service("enrolService")
@Transactional
public class EnrolServiceImpl implements EnrolService {
	@Autowired
	private EnrolDao enrolDao;

	@Override
	public Serializable save(EnrolBill enrol) {
		return enrolDao.save(enrol);
		
	}

	@Override
	public EnrolBill get(Class<EnrolBill> c, Serializable id) {
		 
		return enrolDao.get(c, id);
	}

	@Override
	public void delete(EnrolBill enrol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EnrolBill enrol) {
		enrolDao.update(enrol);
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
	public List<EnrolBill> queryAll(Class<EnrolBill> c) {
		return enrolDao.queryAll(c);
	}

	@Override
	public EnrolBill load(Class<EnrolBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnrolBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnrolBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EnrolBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return enrolDao.query(hql, params, currentPage, rows);
	}
 

	 
}
