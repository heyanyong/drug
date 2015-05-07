package com.gxuts.wss.dms.dao.manage.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.manage.VoteDao;
import com.gxuts.wss.dms.entity.manage.VoteInfo;
@Repository("voteDao")
public class VoteDaoImpl extends BaseDao<VoteInfo> implements VoteDao{

	@Override
	public VoteInfo getAvailable() {
		Query q=this.getSession().createQuery("from VoteInfo where isOpen=true and endTime>?");
		q.setParameter(0, new Date());
		@SuppressWarnings("unchecked")
		List<VoteInfo> l=q.list();
		if (l != null && l.size() > 0) {
			return (VoteInfo) l.get(0);
		}
		return null;
	}

}
