package com.gxuts.wss.dms.service.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.business.PurchaseDao;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.service.business.PurchaseService;
@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseDao purchaseDao;

	@Override
	public Serializable save(PurchaseBill purchaseBill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PurchaseBill purchaseBill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PurchaseBill purchaseBill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PurchaseBill get(Class<PurchaseBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<PurchaseBill> queryAll(Class<PurchaseBill> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseBill load(Class<PurchaseBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PurchaseBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

	 
	 
	 

}
