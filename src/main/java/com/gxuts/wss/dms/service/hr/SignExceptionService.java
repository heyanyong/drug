package com.gxuts.wss.dms.service.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.SignExceptionBill;
import com.gxuts.wss.dms.entity.sys.UrlInfo;

public interface SignExceptionService {
	public Serializable save(SignExceptionBill bill);
	public SignExceptionBill get(Class<SignExceptionBill> c, Serializable id);

	public void delete(SignExceptionBill bill);

	public void update(SignExceptionBill bill);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<SignExceptionBill> queryAll(Class<SignExceptionBill> c);

	public SignExceptionBill load(Class<SignExceptionBill> c, Serializable id);

	public SignExceptionBill get(String hql, Map<String, Object> params);

	public SignExceptionBill getObject(String hql, Object[] params);

	public Page<SignExceptionBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);

}
