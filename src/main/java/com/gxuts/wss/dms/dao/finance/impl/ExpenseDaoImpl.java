package com.gxuts.wss.dms.dao.finance.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.finance.ExpenseDao;
import com.gxuts.wss.dms.entity.finance.ExpenseBill;
import com.gxuts.wss.dms.entity.finance.ExpenseItem;
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.util.DateUtil;

@Repository("expenseDao")
public class ExpenseDaoImpl extends BaseDao<ExpenseBill> implements ExpenseDao {

	// 已用
	public double getExpenseThisMonth(StructureInfo structure, String no) {

		Query q = this.getSession().createQuery(
				"select sum(money) from ExpenseItem where createDate>=? and createDate<=? and structure.id=? and no=?");
		q.setDate(0, DateUtil.getFirstDayOfMonth(Calendar.getInstance()));
		q.setDate(1, DateUtil.getLastDayOfMonth(Calendar.getInstance()));
		q.setParameter(2, structure.getId());
		q.setParameter(3, no);
		List<Double> list = q.list();
		if (list == null || list.size() < 1 || list.get(0) == null) {
			return 0;
		} else {
			return   list.get(0);
		}
	}

	@Override
	public double getBudgetThisMonth(StructureInfo structure, String no) {
		Query q = this.getSession().createQuery(
				"select "+DateUtil.getCurrentMonth()+" from BudgetInfo where   structure.id=? and no=? and year=?");
		q.setParameter(0, structure.getId());
		q.setParameter(1, no);
		q.setParameter(2, DateUtil.getCurrentYear());
		List<Double> list = q.list();
		if (list == null || list.size() < 1 || list.get(0) == null) {
			return 0;
		} else {
			return   list.get(0);
		}
	}

}
