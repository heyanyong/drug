package com.gxuts.wss.dms.service.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.SupplierInfo;
import com.gxuts.wss.dms.util.QueryFilter;

public interface SupplierService {
	public Serializable save(SupplierInfo supplier);

	public void delete(SupplierInfo supplier);

	public void update(SupplierInfo supplier);
	public SupplierInfo get(Class<SupplierInfo> c, Serializable id);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<SupplierInfo> queryAll(Class<SupplierInfo> c);

	public SupplierInfo load(Class<SupplierInfo> c, Serializable id);

	public SupplierInfo get(String hql, Map<String, Object> params);

	public SupplierInfo getObject(String hql, Object[] params);

	public Page<SupplierInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);

	public Page<SupplierInfo> find(QueryFilter filter);
	
}
