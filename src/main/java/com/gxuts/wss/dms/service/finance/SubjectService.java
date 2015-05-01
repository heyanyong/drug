package com.gxuts.wss.dms.service.finance;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.finance.SubjectInfo;

public interface SubjectService {
	public SubjectInfo get(Class<SubjectInfo> c, Serializable id);

	public Serializable save(SubjectInfo subject);
	public void delete(SubjectInfo subject);

	public void update(SubjectInfo subject);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<SubjectInfo> queryAll(Class<SubjectInfo> c);

	public SubjectInfo load(Class<SubjectInfo> c, Serializable id);

	public SubjectInfo get(String hql, Map<String, Object> params);

	public SubjectInfo getObject(String hql, Object[] params);

	public Page<SubjectInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
