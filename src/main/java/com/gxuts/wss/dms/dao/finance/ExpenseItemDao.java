package com.gxuts.wss.dms.dao.finance;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.finance.ExpenseItem;

public interface ExpenseItemDao {
	public Serializable save(ExpenseItem item);
	public ExpenseItem get(Class<ExpenseItem> c, Serializable id);

	public void delete(ExpenseItem item);

	public void update(ExpenseItem item);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<ExpenseItem> queryAll(Class<ExpenseItem> c);

	public ExpenseItem load(Class<ExpenseItem> c, Serializable id);

	public ExpenseItem get(String hql, Map<String, Object> params);

	public ExpenseItem getObject(String hql, Object[] params);

	public Page<ExpenseItem> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
