package com.gxuts.wss.dms.dao.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.EnrolBill;
import com.gxuts.wss.dms.util.QueryFilter;

public interface EnrolDao {
	public Serializable save(EnrolBill info);
	public EnrolBill get(Class<EnrolBill> c, Serializable id);
	public EnrolBill get(String hql, Map<String, Object> params);
	public EnrolBill load(Class<EnrolBill> c, Serializable id);
	public EnrolBill getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<EnrolBill> queryAll(Class<EnrolBill> c);
	public Page<EnrolBill> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public EnrolBill getByNo(Class<EnrolBill> c, String no);  
	public EnrolBill getByHql(String hql);
	public void delete(EnrolBill info);
	public void update(EnrolBill info);
	public Page<EnrolBill> find(QueryFilter filter);
}
