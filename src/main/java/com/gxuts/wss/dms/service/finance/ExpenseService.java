package com.gxuts.wss.dms.service.finance;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.finance.ExpenseBill;

public interface ExpenseService {
	public Serializable save(ExpenseBill expense);
	public ExpenseBill get(Class<ExpenseBill> c, Serializable id);

	public void delete(ExpenseBill expense);

	public void update(ExpenseBill expense);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<ExpenseBill> queryAll(Class<ExpenseBill> c);

	public ExpenseBill load(Class<ExpenseBill> c, Serializable id);

	public ExpenseBill get(String hql, Map<String, Object> params);

	public ExpenseBill getObject(String hql, Object[] params);

	public Page<ExpenseBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
