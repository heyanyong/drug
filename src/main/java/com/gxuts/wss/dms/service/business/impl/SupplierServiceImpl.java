package com.gxuts.wss.dms.service.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.business.SupplierDao;
import com.gxuts.wss.dms.entity.business.SupplierInfo;
import com.gxuts.wss.dms.service.business.SupplierService;
@Service("supplierService")
@Transactional
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierDao supplierDao;

	@Override
	public Serializable save(SupplierInfo supplier) {
		return supplierDao.save(supplier);
	}

	@Override
	public void delete(SupplierInfo supplier) {
		supplierDao.delete(supplier);
	}

	@Override
	public void update(SupplierInfo supplier) {
		supplierDao.update(supplier);
	}

	@Override
	public SupplierInfo get(Class<SupplierInfo> c, Serializable id) {
		return supplierDao.get(c, id);
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
	public List<SupplierInfo> queryAll(Class<SupplierInfo> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierInfo load(Class<SupplierInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierInfo get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierInfo getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SupplierInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		hql="from SupplierInfo";
		return supplierDao.query(hql, params, currentPage, rows);
	}

	 
	 

}
