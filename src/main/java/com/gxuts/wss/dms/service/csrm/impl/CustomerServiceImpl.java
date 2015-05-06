package com.gxuts.wss.dms.service.csrm.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.csrm.CustomerDao;
import com.gxuts.wss.dms.entity.csrm.CustomerInfo;
import com.gxuts.wss.dms.service.csrm.CustomerService;
import com.gxuts.wss.dms.util.QueryFilter;
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Serializable save(CustomerInfo customer) {
		return customerDao.save(customer);
	}

	@Override
	public void delete(CustomerInfo customer) {
		customerDao.delete(customer);
	}

	@Override
	public void update(CustomerInfo customer) {
		customerDao.update(customer);
	}

	@Override
	public CustomerInfo get(Class<CustomerInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return customerDao.get(c, id);
	}

	@Override
	public int executeHql(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerInfo> queryAll(Class<CustomerInfo> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerInfo load(Class<CustomerInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerInfo get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerInfo getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		hql="from CustomerInfo";
		return customerDao.query(hql, params, currentPage, rows);
	}

	@Override
	public Page<CustomerInfo> find(QueryFilter filter) {
		return customerDao.find(filter);
	}

	 
	 

}
