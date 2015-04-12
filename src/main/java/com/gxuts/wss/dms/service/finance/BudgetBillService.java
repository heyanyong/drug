package com.gxuts.wss.dms.service.finance;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.finance.BudgetBill;

public interface BudgetBillService {
	public BudgetBill get(Class<BudgetBill> c, Serializable id);

	public void delete(BudgetBill bill);
	public void saveOrUpdate(BudgetBill bill);

	public void update(BudgetBill bill);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<BudgetBill> queryAll(Class<BudgetBill> c);

	public BudgetBill load(Class<BudgetBill> c, Serializable id);

	public BudgetBill get(String hql, Map<String, Object> params);

	public BudgetBill getObject(String hql, Object[] params);

	public Page<BudgetBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
