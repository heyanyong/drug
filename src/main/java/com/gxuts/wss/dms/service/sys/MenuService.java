package com.gxuts.wss.dms.service.sys;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.sys.MenuInfo;

public interface MenuService {
	public Serializable save(MenuInfo menu);
	public MenuInfo get(Class<MenuInfo> c, Serializable id);
	public MenuInfo get(String hql, Map<String, Object> params);
	public MenuInfo load(Class<MenuInfo> c, Serializable id);
	public MenuInfo getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<MenuInfo> queryAll();
	public Page<MenuInfo> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public MenuInfo getByNo(Class<MenuInfo> c, String no);  
	public MenuInfo getByHql(String hql);
	public void delete(MenuInfo menu);
	public void update(MenuInfo menu);
}
