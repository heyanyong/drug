package com.gxuts.wss.dms.dao.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.QuitBill;
import com.gxuts.wss.dms.util.QueryFilter;

public interface QuitDao {
	public Serializable save(QuitBill info);
	public QuitBill get(Class<QuitBill> c, Serializable id);
	public QuitBill get(String hql, Map<String, Object> params);
	public QuitBill load(Class<QuitBill> c, Serializable id);
	public QuitBill getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<QuitBill> queryAll(Class<QuitBill> c);
	public Page<QuitBill> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public QuitBill getByNo(Class<QuitBill> c, String no);  
	public QuitBill getByHql(String hql);
	public void delete(QuitBill info);
	public void update(QuitBill info);
	public Page<QuitBill> find(QueryFilter filter);
}
