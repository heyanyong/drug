package com.gxuts.wss.dms.dao.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.PurchaseBill;

public interface PurchaseDao {
	public Serializable save(PurchaseBill purchaseBill);

	public void delete(PurchaseBill purchaseBill);

	public void update(PurchaseBill purchaseBill);
	public PurchaseBill get(Class<PurchaseBill> c, Serializable id);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<PurchaseBill> queryAll(Class<PurchaseBill> c);

	public PurchaseBill load(Class<PurchaseBill> c, Serializable id);

	public PurchaseBill get(String hql, Map<String, Object> params);

	public PurchaseBill getObject(String hql, Object[] params);

	public Page<PurchaseBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
