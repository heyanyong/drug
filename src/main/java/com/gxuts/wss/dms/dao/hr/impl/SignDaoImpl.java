package com.gxuts.wss.dms.dao.hr.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.hr.SignDao;
import com.gxuts.wss.dms.entity.hr.SignInfo;
@Repository("signDao")
public class SignDaoImpl extends BaseDao<SignInfo> implements SignDao{
	public SignInfo getByRecord(String userNo,Date recordDate){
		Query q=this.getSession().createQuery("from SignInfo where userNo=? and recordDate=?");
		q.setParameter(0, userNo);
		q.setDate(1, recordDate);
		List<SignInfo> l=q.list();
		if (l != null && l.size() > 0) {
			return (SignInfo) l.get(0);
		}
		return null;
	}
 

}
