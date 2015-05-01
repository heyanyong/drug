package com.gxuts.wss.dms.service.finance.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.finance.SubjectDao;
import com.gxuts.wss.dms.entity.finance.SubjectInfo;
import com.gxuts.wss.dms.service.finance.SubjectService;
@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectDao subjectDao;

	 

	@Override
	public SubjectInfo get(Class<SubjectInfo> c, Serializable id) {
		return subjectDao.get(c, id);
	}

	@Override
	public void delete(SubjectInfo subject) {
		subjectDao.delete(subject);
	}

	@Override
	public void update(SubjectInfo subject) {
		subjectDao.update(subject);
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		return 0;
	}

	@Override
	public List<SubjectInfo> queryAll(Class<SubjectInfo> c) {
		return null;
	}

	@Override
	public SubjectInfo load(Class<SubjectInfo> c, Serializable id) {
		return null;
	}

	@Override
	public SubjectInfo get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectInfo getObject(String hql, Object[] params) {
		return subjectDao.getObject(hql, params);
	}

	@Override
	public Page<SubjectInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return subjectDao.query(hql, params, currentPage, rows);
	}

	@Override
	public Serializable save(SubjectInfo subject) {
		return subjectDao.save(subject);
	}

 
}
