package com.gxuts.wss.dms.service.csrm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.csrm.PurchaseBill;
import com.gxuts.wss.dms.entity.csrm.PurchaseContractBill;

public interface PurchaseService {
	public Serializable save(PurchaseBill purchase);

	public void delete(PurchaseBill purchase);

	public void update(PurchaseBill purchase);
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
