package com.gxuts.wss.dms.service.finance.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.finance.BudgetBillDao;
import com.gxuts.wss.dms.entity.finance.BudgetBill;
import com.gxuts.wss.dms.service.finance.BudgetBillService;
@Service("budgetBillService")
@Transactional
public class BudgetBillServiceImpl implements BudgetBillService {
	@Autowired
	private BudgetBillDao billBillDao;

	@Override
	public void saveOrUpdate(BudgetBill bill) {
		billBillDao.saveOrUpdate(bill);
	}

	@Override
	public BudgetBill get(Class<BudgetBill> c, Serializable id) {
		return billBillDao.get(c, id);
	}

	@Override
	public void delete(BudgetBill bill) {
		billBillDao.executeHql("delete from ExpenseItem where bill_id="+bill.getId());
		billBillDao.delete(bill);
	}

	@Override
	public void update(BudgetBill bill) {
		billBillDao.update(bill);
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
	public List<BudgetBill> queryAll(Class<BudgetBill> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BudgetBill load(Class<BudgetBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BudgetBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BudgetBill getObject(String hql, Object[] params) {
		return billBillDao.getObject(hql, params);
	}

	@Override
	public Page<BudgetBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return billBillDao.query(hql, params, currentPage, rows);
	}


	 

}
