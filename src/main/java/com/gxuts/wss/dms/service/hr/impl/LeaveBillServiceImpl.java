package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.hr.LeaveBillDao;
import com.gxuts.wss.dms.entity.hr.LeaveBill;
import com.gxuts.wss.dms.service.hr.LeaveBillService;
@Service("leaveBillService")
@Transactional
public class LeaveBillServiceImpl implements LeaveBillService {
	@Autowired
	private LeaveBillDao leaveBillDao;

	@Override
	public Serializable save(LeaveBill leaveBill) {
		return leaveBillDao.save(leaveBill);
	}

	@Override
	public LeaveBill get(Class<LeaveBill> c, Serializable id) {
		return null;
	}

	@Override
	public void delete(LeaveBill leaveBill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LeaveBill leaveBill) {
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
	public List<LeaveBill> queryAll(Class<LeaveBill> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaveBill load(Class<LeaveBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaveBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaveBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<LeaveBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

	 
 

}
