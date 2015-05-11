package com.gxuts.wss.dms.service.manage.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.manage.AssetDao;
import com.gxuts.wss.dms.dao.manage.AssetPurchaseDao;
import com.gxuts.wss.dms.entity.manage.AssetInfo;
import com.gxuts.wss.dms.entity.manage.AssetPurchaseBill;
import com.gxuts.wss.dms.service.manage.AssetPurchaseService;
import com.gxuts.wss.dms.util.QueryFilter;
@Service("assetPurchaseService")
@Transactional
public class AssetPurchaseServiceImpl implements AssetPurchaseService {
	@Autowired
	private AssetPurchaseDao assetPurchaseDao;
	@Autowired
	private AssetDao assetDao;

	@Override
	public Serializable save(AssetPurchaseBill assetPurchase) {
		return assetPurchaseDao.save(assetPurchase);
		
	}
	@Override
	public AssetPurchaseBill get(Class<AssetPurchaseBill> c, Serializable id) {
		return assetPurchaseDao.get(c, id);
	}

	@Override
	public AssetPurchaseBill get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public AssetPurchaseBill load(Class<AssetPurchaseBill> c, Serializable id) {
		return null;
	}

	@Override
	public AssetPurchaseBill getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public List<AssetPurchaseBill> queryAll() {
		return assetPurchaseDao.queryAll(AssetPurchaseBill.class);
	}

	@Override
	public Page<AssetPurchaseBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return assetPurchaseDao.query("from AssetPurchaseBill", params, currentPage, rows);
	}

	@Override
	public AssetPurchaseBill getByNo(Class<AssetPurchaseBill> c, String no) {
		return null;
	}
	@Override
	public AssetPurchaseBill getByHql(String hql) {
		return null;
	}
	@Override
	public void delete(AssetPurchaseBill assetPurchase) {
		assetPurchase=assetPurchaseDao.get(AssetPurchaseBill.class, assetPurchase.getId());
		List<AssetInfo> items=assetPurchase.getItems();
		assetPurchaseDao.delete(assetPurchase);
		for (AssetInfo asset:items) {
			assetDao.delete(asset);
		}
	}
	@Override
	public void update(AssetPurchaseBill assetPurchase) {
		assetPurchaseDao.update(assetPurchase);
	}
	@Override
	public Page<AssetPurchaseBill> find(QueryFilter filter) {
		return assetPurchaseDao.find(filter);
	}
}
