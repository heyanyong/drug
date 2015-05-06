package com.gxuts.wss.dms.dao.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.PayBill;
import com.gxuts.wss.dms.util.QueryFilter;

public interface PayDao {
	public Serializable save(PayBill pay);

	public void delete(PayBill pay);

	public void update(PayBill pay);
	public PayBill get(Class<PayBill> c, Serializable id);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<PayBill> queryAll(Class<PayBill> c);

	public PayBill load(Class<PayBill> c, Serializable id);

	public PayBill get(String hql, Map<String, Object> params);

	public PayBill getObject(String hql, Object[] params);

	public Page<PayBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	public Page<PayBill> find(QueryFilter filter);
}
