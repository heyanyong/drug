package com.gxuts.wss.dms.service.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.business.PayDao;
import com.gxuts.wss.dms.entity.business.PayBill;
import com.gxuts.wss.dms.entity.business.PayItem;
import com.gxuts.wss.dms.service.business.PayService;
import com.gxuts.wss.dms.util.QueryFilter;
@Service("payService")
@Transactional
public class PayServiceImpl implements PayService {
	@Autowired
	private PayDao payDao;

	@Override
	public Serializable save(PayBill pay) {
		return payDao.save(pay);
	}

	@Override
	public void delete(PayBill pay) {
		payDao.delete(pay);
	}

	@Override
	public void update(PayBill pay) {
		payDao.update(pay);
	}

	@Override
	public PayBill get(Class<PayBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return payDao.get(c, id);
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
	public List<PayBill> queryAll(Class<PayBill> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayBill load(Class<PayBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PayBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		hql="from PayBill";
		return payDao.query(hql, params, currentPage, rows);
	}

	@Override
	public Page<PayBill> find(QueryFilter filter) {
		return payDao.find(filter);
	}

	 
	 

}
