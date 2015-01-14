package com.gxuts.wss.drug.service.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.drug.entity.UserInfo;

public interface UserService {
	public Serializable save(UserInfo user);
	public UserInfo get(Class<UserInfo> c, Serializable id);
	public UserInfo get(String hql, Map<String, Object> params);
	public UserInfo load(Class<UserInfo> c, Serializable id);
	public UserInfo getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public UserInfo checkLogin(UserInfo user);
	public List<UserInfo> queryAll(Class<UserInfo> c);
}
