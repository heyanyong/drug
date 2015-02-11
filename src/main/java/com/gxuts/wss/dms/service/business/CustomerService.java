package com.gxuts.wss.dms.service.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.CustomerInfo;

public interface CustomerService {
	public Serializable save(CustomerInfo customer);

	public void delete(CustomerInfo customer);

	public void update(CustomerInfo customer);
	public CustomerInfo get(Class<CustomerInfo> c, Serializable id);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<CustomerInfo> queryAll(Class<CustomerInfo> c);

	public CustomerInfo load(Class<CustomerInfo> c, Serializable id);

	public CustomerInfo get(String hql, Map<String, Object> params);

	public CustomerInfo getObject(String hql, Object[] params);

	public Page<CustomerInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
