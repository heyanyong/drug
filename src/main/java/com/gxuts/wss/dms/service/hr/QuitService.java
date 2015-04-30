package com.gxuts.wss.dms.service.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.QuitBill;
import com.gxuts.wss.dms.entity.sys.UrlInfo;

public interface QuitService {
	public Serializable save(QuitBill bill);
	public QuitBill get(Class<QuitBill> c, Serializable id);

	public void delete(QuitBill bill);

	public void update(QuitBill bill);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<QuitBill> queryAll(Class<QuitBill> c);

	public QuitBill load(Class<QuitBill> c, Serializable id);

	public QuitBill get(String hql, Map<String, Object> params);

	public QuitBill getObject(String hql, Object[] params);

	public Page<QuitBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);

}
