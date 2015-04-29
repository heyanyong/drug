package com.gxuts.wss.dms.dao.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.manage.VoteItem;

public interface VoteItemDao {
	public Serializable save(VoteItem voteItem);
	public VoteItem get(Class<VoteItem> c, Serializable id);
	public VoteItem get(String hql, Map<String, Object> params);
	public VoteItem load(Class<VoteItem> c, Serializable id);
	public VoteItem getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<VoteItem> queryAll(Class<VoteItem> c);
	public Page<VoteItem> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public VoteItem getByNo(Class<VoteItem> c, String no);  
	public VoteItem getByHql(String hql);
	public void delete(VoteItem voteItem);
	public void update(VoteItem voteItem);

}