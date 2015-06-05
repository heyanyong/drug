package com.gxuts.wss.dms.dao.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.LeaveBill;
import com.gxuts.wss.dms.util.QueryFilter;

public interface LeaveBillDao {
	public Serializable save(LeaveBill leaveBill);
	public LeaveBill get(Class<LeaveBill> c, Serializable id);

	public void delete(LeaveBill leaveBill);

	public void update(LeaveBill leaveBill);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<LeaveBill> queryAll(Class<LeaveBill> c);

	public LeaveBill load(Class<LeaveBill> c, Serializable id);

	public LeaveBill get(String hql, Map<String, Object> params);

	public LeaveBill getObject(String hql, Object[] params);

	public Page<LeaveBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	public Page<LeaveBill> find(QueryFilter filter);
}
