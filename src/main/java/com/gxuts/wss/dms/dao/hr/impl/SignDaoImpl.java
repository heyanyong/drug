package com.gxuts.wss.dms.dao.hr.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.hr.SignDao;
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.util.DateUtil;
@Repository("signDao")
public class SignDaoImpl extends BaseDao<SignInfo> implements SignDao{
	public SignInfo getByRecord(String userNo,Date recordDate){
		Query q=this.getSession().createQuery("from SignInfo where userNo=? and recordDate=?");
		q.setParameter(0, userNo);
		q.setDate(1, recordDate);
		@SuppressWarnings("unchecked")
		List<SignInfo> l=q.list();
		if (l != null && l.size() > 0) {
			return (SignInfo) l.get(0);
		}
		return null;
	}

	@Override
	public Page<SignInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer numPerPage) {
		currentPage=currentPage==null? 1:currentPage; 
		numPerPage=numPerPage==null? 17:numPerPage; 
		Page<SignInfo> page=new Page<SignInfo>();
		Date startDate=(Date) params.get("startDate");
		Date endDate=(Date) params.get("endDate");
		Query q=this.getSession().createQuery("from SignInfo where recordDate>=? and recordDate<=?");
		q.setDate(0, startDate==null? DateUtil.string2Date("2015-01-01", "yyyy-MM-dd"):startDate);
		q.setDate(1, endDate==null? new Date():endDate);
		page.setTotalCount(q.list().size());
		page.setData(q.setFirstResult((currentPage - 1) * numPerPage).setMaxResults(numPerPage).list());
		page.setPageNumShown(5);
		page.setCurrentPage(currentPage);
		page.setNumPerPage(numPerPage);
		return page;
	}
	
 

}
