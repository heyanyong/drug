package com.gxuts.wss.dms.service.manage.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.manage.AssetPurchaseContractDao;
import com.gxuts.wss.dms.entity.manage.AssetPurchaseContractBill;
import com.gxuts.wss.dms.service.manage.AssetPurchaseContractService;
import com.gxuts.wss.dms.util.QueryFilter;
@Service("assetPurchaseContractService")
@Transactional
public class AssetPurchaseContractServiceImpl implements AssetPurchaseContractService {
	@Autowired
	private AssetPurchaseContractDao assetPurchaseContractDao;

	@Override
	public Serializable save(AssetPurchaseContractBill assetPurchaseContract) {
		return assetPurchaseContractDao.save(assetPurchaseContract);
		
	}
	@Override
	public AssetPurchaseContractBill get(Class<AssetPurchaseContractBill> c, Serializable id) {
		return assetPurchaseContractDao.get(c, id);
	}

	@Override
	public AssetPurchaseContractBill get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public AssetPurchaseContractBill load(Class<AssetPurchaseContractBill> c, Serializable id) {
		return null;
	}

	@Override
	public AssetPurchaseContractBill getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public List<AssetPurchaseContractBill> queryAll() {
		return assetPurchaseContractDao.queryAll(AssetPurchaseContractBill.class);
	}

	@Override
	public Page<AssetPurchaseContractBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return assetPurchaseContractDao.query("from AssetPurchaseContractBill", params, currentPage, rows);
	}

	@Override
	public AssetPurchaseContractBill getByNo(Class<AssetPurchaseContractBill> c, String no) {
		return null;
	}
	@Override
	public AssetPurchaseContractBill getByHql(String hql) {
		return null;
	}
	@Override
	public void delete(AssetPurchaseContractBill assetPurchaseContract) {
		assetPurchaseContractDao.delete(assetPurchaseContract);
	}
	@Override
	public void update(AssetPurchaseContractBill assetPurchaseContract) {
		assetPurchaseContractDao.update(assetPurchaseContract);
	}
	@Override
	public Page<AssetPurchaseContractBill> find(QueryFilter filter) {
		return assetPurchaseContractDao.find(filter);
	}
}
