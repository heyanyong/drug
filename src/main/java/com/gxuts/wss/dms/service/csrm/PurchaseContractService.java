package com.gxuts.wss.dms.service.csrm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.csrm.PurchaseContractBill;

public interface PurchaseContractService {
	public Serializable save(PurchaseContractBill contract);

	public void delete(PurchaseContractBill contract);

	public void update(PurchaseContractBill contract);
	public PurchaseContractBill get(Class<PurchaseContractBill> c, Serializable id);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<PurchaseContractBill> queryAll(Class<PurchaseContractBill> c);

	public PurchaseContractBill load(Class<PurchaseContractBill> c, Serializable id);

	public PurchaseContractBill get(String hql, Map<String, Object> params);

	public PurchaseContractBill getObject(String hql, Object[] params);

	public Page<PurchaseContractBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	public PurchaseContractBill fromPurchase(Integer purchaseId);
}
