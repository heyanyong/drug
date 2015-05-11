package com.gxuts.wss.dms.service.manage.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.manage.AssetDao;
import com.gxuts.wss.dms.entity.manage.AssetInfo;
import com.gxuts.wss.dms.service.manage.AssetService;
@Service("assetService")
@Transactional
public class AssetServiceImpl implements AssetService {
	@Autowired
	private AssetDao assetDao;

	@Override
	public Serializable save(AssetInfo asset) {
		return assetDao.save(asset);
		
	}
	@Override
	public AssetInfo get(Class<AssetInfo> c, Serializable id) {
		return assetDao.get(c, id);
	}

	@Override
	public AssetInfo get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public AssetInfo load(Class<AssetInfo> c, Serializable id) {
		return null;
	}

	@Override
	public AssetInfo getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public List<AssetInfo> queryAll() {
		return assetDao.queryAll(AssetInfo.class);
	}

	@Override
	public Page<AssetInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return assetDao.query("from AssetInfo", params, currentPage, rows);
	}

	@Override
	public AssetInfo getByNo(Class<AssetInfo> c, String no) {
		return null;
	}

	@Override
	public AssetInfo getByHql(String hql) {
		return null;
	}

	@Override
	public void delete(AssetInfo asset) {
		assetDao.delete(asset);
	}

	@Override
	public void update(AssetInfo asset) {
		assetDao.update(asset);
	}

}
