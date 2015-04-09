package com.gxuts.wss.dms.service.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.manage.VoteInfo;

public interface VoteService {
	public void vote(UserInfo user,int voteId,int itId);
	public Serializable save(VoteInfo vote);
	public VoteInfo get(Class<VoteInfo> c, Serializable id);
	public VoteInfo get(String hql, Map<String, Object> params);
	public VoteInfo load(Class<VoteInfo> c, Serializable id);
	public VoteInfo getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<VoteInfo> queryAll();
	public Page<VoteInfo> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public VoteInfo getByNo(Class<VoteInfo> c, String no);  
	public VoteInfo getByHql(String hql);
	public void delete(VoteInfo vote);
	public void update(VoteInfo vote);
}
