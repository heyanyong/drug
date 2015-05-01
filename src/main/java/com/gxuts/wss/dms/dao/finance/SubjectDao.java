package com.gxuts.wss.dms.dao.finance;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.finance.SubjectInfo;

public interface SubjectDao {
	public Serializable save(SubjectInfo info);
	public SubjectInfo get(Class<SubjectInfo> c, Serializable id);

	public void delete(SubjectInfo info);

	public void update(SubjectInfo info);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<SubjectInfo> queryAll(Class<SubjectInfo> c);

	public SubjectInfo load(Class<SubjectInfo> c, Serializable id);

	public SubjectInfo get(String hql, Map<String, Object> params);

	public SubjectInfo getObject(String hql, Object[] params);

	public Page<SubjectInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	public String queryOneField(String hql);
}
