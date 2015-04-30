package com.gxuts.wss.dms.service.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.EnrolBill;
import com.gxuts.wss.dms.entity.sys.UrlInfo;

public interface EnrolService {
	public Serializable save(EnrolBill bill);
	public EnrolBill get(Class<EnrolBill> c, Serializable id);

	public void delete(EnrolBill bill);

	public void update(EnrolBill bill);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<EnrolBill> queryAll(Class<EnrolBill> c);

	public EnrolBill load(Class<EnrolBill> c, Serializable id);

	public EnrolBill get(String hql, Map<String, Object> params);

	public EnrolBill getObject(String hql, Object[] params);

	public Page<EnrolBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);

}
