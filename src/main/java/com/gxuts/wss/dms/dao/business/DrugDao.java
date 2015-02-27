package com.gxuts.wss.dms.dao.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.DrugInfo;

public interface DrugDao {
	public Serializable save(DrugInfo drug);

	public void delete(DrugInfo drug);

	public void update(DrugInfo drug);
	public DrugInfo get(Class<DrugInfo> c, Serializable id);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<DrugInfo> queryAll(Class<DrugInfo> c);

	public DrugInfo load(Class<DrugInfo> c, Serializable id);

	public DrugInfo get(String hql, Map<String, Object> params);

	public DrugInfo getObject(String hql, Object[] params);

	public Page<DrugInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	public Page<Object[]> queryDrugList(Map<String, Object> params, Integer currentPage, Integer numPerPage);
}
