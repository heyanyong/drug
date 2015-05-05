package com.gxuts.wss.dms.service.finance.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.finance.ExpenseDao;
import com.gxuts.wss.dms.entity.finance.ExpenseBill;
import com.gxuts.wss.dms.entity.finance.ExpenseItem;
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.sys.Json;
import com.gxuts.wss.dms.service.finance.ExpenseService;

import cucumber.api.java.ca.Cal;
@Service("expenseService")
@Transactional
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private ExpenseDao expenseDao;

	@Override
	public Json save(ExpenseBill expense) {
		List<ExpenseItem> items=expense.getItems();
		Calendar date=Calendar.getInstance();
		for(ExpenseItem it:items){
			//预算
			double budget=expenseDao.getBudgetThisMonth(it.getStructure(),it.getNo());
			if(budget<=0){
				return new Json("当月预算为"+budget, "300", null, null,null, null);
			}
			//已用
			double used=expenseDao.getExpenseThisMonth(it.getStructure(), it.getNo());
			double m=budget-used-it.getMoney();
			if(m<0){
				return new Json(it.getName()+"超标"+-m, "300", null, null,null, null);
			}
			it.setExpense(expense);
		}
	    expenseDao.save(expense);
		return new Json("报销单保存成功", "200", "expenseList", "expenseList",
				"closeCurrent", "expense/list");
		
	}

	@Override
	public ExpenseBill get(Class<ExpenseBill> c, Serializable id) {
		return expenseDao.get(c, id);
	}

	@Override
	public void delete(ExpenseBill expense) {
		expenseDao.executeHql("delete from ExpenseItem where expense_id="+expense.getId());
		expenseDao.delete(expense);
	}

	@Override
	public void update(ExpenseBill expense) {
		expenseDao.update(expense);
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
	public List<ExpenseBill> queryAll(Class<ExpenseBill> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpenseBill load(Class<ExpenseBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpenseBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpenseBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ExpenseBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return expenseDao.query(hql, params, currentPage, rows);
	}

	@Override
	public double getExpenseThisMonth(StructureInfo structure, String no) {
		return expenseDao.getExpenseThisMonth(structure, no);
	}

}
