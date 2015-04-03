package com.gxuts.wss.dms.service.finance;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.finance.BudgetInfo;

public interface BudgetService {
	public Serializable saveUpdate(BudgetInfo budget);
	public BudgetInfo get(Class<BudgetInfo> c, Serializable id);

	public void delete(BudgetInfo budget);

	public void update(BudgetInfo budget);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<BudgetInfo> queryAll(Class<BudgetInfo> c);

	public BudgetInfo load(Class<BudgetInfo> c, Serializable id);

	public BudgetInfo get(String hql, Map<String, Object> params);

	public BudgetInfo getObject(String hql, Object[] params);

	public Page<BudgetInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
