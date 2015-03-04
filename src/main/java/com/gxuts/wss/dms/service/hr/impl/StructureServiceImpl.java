package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.hr.StructureDao;
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.service.hr.StructureService;
@Service("structureService")
@Transactional
public class StructureServiceImpl implements StructureService {
	@Autowired
	private StructureDao structureDao;

	@Override
	public Serializable save(StructureInfo structure) {
		return structureDao.save(structure);
		
	}


	@Override
	public StructureInfo get(Class<StructureInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StructureInfo get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StructureInfo load(Class<StructureInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StructureInfo getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeHql(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StructureInfo> queryAll(Class<StructureInfo> c) {
		return structureDao.queryAll(c);
	}

	@Override
	public Page<StructureInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		// TODO Auto-generated method stub
		return structureDao.query(hql, params, currentPage, rows);
	}

	@Override
	public StructureInfo getByNo(Class<StructureInfo> c, String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StructureInfo getByHql(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(StructureInfo structure) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StructureInfo structure) {
		// TODO Auto-generated method stub
		
	}

}
