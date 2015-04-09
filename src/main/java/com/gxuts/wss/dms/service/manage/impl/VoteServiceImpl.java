package com.gxuts.wss.dms.service.manage.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.manage.VoteDao;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.VoteInfo;
import com.gxuts.wss.dms.entity.manage.VoteItem;
import com.gxuts.wss.dms.service.manage.VoteService;
@Service("voteService")
@Transactional
public class VoteServiceImpl implements VoteService {
	@Autowired
	private VoteDao voteDao;

	@Override
	public Serializable save(VoteInfo vote) {
		return voteDao.save(vote);
		
	}
	@Override
	public VoteInfo get(Class<VoteInfo> c, Serializable id) {
		return voteDao.get(c, id);
	}

	@Override
	public VoteInfo get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public VoteInfo load(Class<VoteInfo> c, Serializable id) {
		return null;
	}

	@Override
	public VoteInfo getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public List<VoteInfo> queryAll() {
		return voteDao.queryAll(VoteInfo.class);
	}

	@Override
	public Page<VoteInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return voteDao.query("from VoteInfo", params, currentPage, rows);
	}

	@Override
	public VoteInfo getByNo(Class<VoteInfo> c, String no) {
		return null;
	}

	@Override
	public VoteInfo getByHql(String hql) {
		return null;
	}

	@Override
	public void delete(VoteInfo vote) {
		voteDao.delete(vote);
	}

	@Override
	public void update(VoteInfo vote) {
		voteDao.update(vote);
	}
	@Override
	public void vote(UserInfo user, int voteId, int itId) {
		VoteInfo vote=voteDao.get(VoteInfo.class, voteId);
		List<VoteItem> items=vote.getItems();
		for(VoteItem v:items){
			if(v.getId()==itId){
				v.getUsers().add(user);
				v.setVoteNum(v.getVoteNum()+1);
			}
		}
		voteDao.update(vote);
	}
	 

}
