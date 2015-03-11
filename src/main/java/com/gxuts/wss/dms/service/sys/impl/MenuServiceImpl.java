package com.gxuts.wss.dms.service.sys.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.sys.MenuDao;
import com.gxuts.wss.dms.entity.sys.MenuInfo;
import com.gxuts.wss.dms.service.sys.MenuService;
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	@Override
	public Serializable save(MenuInfo menu) {
		return menuDao.save(menu);
		
	}
	@Override
	public MenuInfo get(Class<MenuInfo> c, Serializable id) {
		return null;
	}

	@Override
	public MenuInfo get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public MenuInfo load(Class<MenuInfo> c, Serializable id) {
		return null;
	}

	@Override
	public MenuInfo getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public List<MenuInfo> queryAll() {
		return menuDao.queryAll(MenuInfo.class);
	}

	@Override
	public Page<MenuInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return menuDao.query(hql, params, currentPage, rows);
	}

	@Override
	public MenuInfo getByNo(Class<MenuInfo> c, String no) {
		return null;
	}

	@Override
	public MenuInfo getByHql(String hql) {
		return null;
	}

	@Override
	public void delete(MenuInfo menu) {
		menuDao.delete(menu);
	}

	@Override
	public void update(MenuInfo menu) {
		menuDao.update(menu);
	}

}
