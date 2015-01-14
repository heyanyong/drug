package com.gxuts.wss.drug.service.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.drug.base.Page;
import com.gxuts.wss.drug.entity.RoleInfo;

public interface RoleService {
	public Serializable save(RoleInfo role);
	public RoleInfo get(Class<RoleInfo> c, Serializable id);

	public void delete(RoleInfo role);

	public void update(RoleInfo role);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<RoleInfo> queryAll(Class<RoleInfo> c);

	public RoleInfo load(Class<RoleInfo> c, Serializable id);

	public RoleInfo get(String hql, Map<String, Object> params);

	public RoleInfo getObject(String hql, Object[] params);

	public Page<RoleInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);

}
