package com.gxuts.wss.drug.dao.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.drug.base.Page;
import com.gxuts.wss.drug.entity.hr.UserInfo;

public interface UserDao {
	public Serializable save(UserInfo user);
	public UserInfo get(Class<UserInfo> c, Serializable id);
	public UserInfo get(String hql, Map<String, Object> params);
	public UserInfo load(Class<UserInfo> c, Serializable id);
	public UserInfo getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<UserInfo> queryAll(Class<UserInfo> c);
	public Page<UserInfo> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
}
