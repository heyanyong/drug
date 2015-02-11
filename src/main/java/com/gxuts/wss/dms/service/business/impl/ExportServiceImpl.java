package com.gxuts.wss.dms.service.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.business.ExportDao;
import com.gxuts.wss.dms.entity.business.ExportBill;
import com.gxuts.wss.dms.service.business.ExportService;
@Service("exportService")
@Transactional
public class ExportServiceImpl implements ExportService {
	@Autowired
	private ExportDao exportDao;

	@Override
	public Serializable save(ExportBill exportBill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ExportBill exportBill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ExportBill exportBill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExportBill get(Class<ExportBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<ExportBill> queryAll(Class<ExportBill> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExportBill load(Class<ExportBill> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExportBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExportBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ExportBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

	 	

	 
	 

}
