package com.gxuts.wss.dms.service.finance.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.finance.BudgetDao;
import com.gxuts.wss.dms.entity.finance.BudgetInfo;
import com.gxuts.wss.dms.service.finance.BudgetService;
@Service("budgetService")
@Transactional
public class BudgetServiceImpl implements BudgetService {
	@Autowired
	private BudgetDao budgetDao;

	@Override
	public Serializable save(BudgetInfo budget) {
		return budgetDao.save(budget);
		
	}

	@Override
	public BudgetInfo get(Class<BudgetInfo> c, Serializable id) {
		return budgetDao.get(c, id);
	}

	@Override
	public void delete(BudgetInfo budget) {
		budgetDao.executeHql("delete from ExpenseItem where budget_id="+budget.getId());
		budgetDao.delete(budget);
	}

	@Override
	public void update(BudgetInfo budget) {
		budgetDao.update(budget);
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
	public List<BudgetInfo> queryAll(Class<BudgetInfo> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BudgetInfo load(Class<BudgetInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BudgetInfo get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BudgetInfo getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BudgetInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return budgetDao.query(hql, params, currentPage, rows);
	}

}
