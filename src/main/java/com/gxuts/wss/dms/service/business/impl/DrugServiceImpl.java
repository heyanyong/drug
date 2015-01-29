package com.gxuts.wss.dms.service.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.business.DrugDao;
import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.service.business.DrugService;
@Service("drugService")
@Transactional
public class DrugServiceImpl implements DrugService {
	@Autowired
	private DrugDao drugDao;

	@Override
	public Serializable save(DrugInfo drug) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(DrugInfo drug) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DrugInfo drug) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DrugInfo get(Class<DrugInfo> c, Serializable id) {
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
	public List<DrugInfo> queryAll(Class<DrugInfo> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrugInfo load(Class<DrugInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrugInfo get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrugInfo getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DrugInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

	 

	 
	 

}
