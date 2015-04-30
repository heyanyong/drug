package com.gxuts.wss.dms.dao.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.SignExceptionBill;
import com.gxuts.wss.dms.util.QueryFilter;

public interface SignExceptionDao {
	public Serializable save(SignExceptionBill info);
	public SignExceptionBill get(Class<SignExceptionBill> c, Serializable id);
	public SignExceptionBill get(String hql, Map<String, Object> params);
	public SignExceptionBill load(Class<SignExceptionBill> c, Serializable id);
	public SignExceptionBill getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<SignExceptionBill> queryAll(Class<SignExceptionBill> c);
	public Page<SignExceptionBill> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public SignExceptionBill getByNo(Class<SignExceptionBill> c, String no);  
	public SignExceptionBill getByHql(String hql);
	public void delete(SignExceptionBill info);
	public void update(SignExceptionBill info);
	public Page<SignExceptionBill> find(QueryFilter filter);
}
