package com.gxuts.wss.dms.dao.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.manage.AssetPurchaseBill;
import com.gxuts.wss.dms.util.QueryFilter;

public interface AssetPurchaseDao {
	public Serializable save(AssetPurchaseBill bill);
	public AssetPurchaseBill get(Class<AssetPurchaseBill> c, Serializable id);
	public AssetPurchaseBill get(String hql, Map<String, Object> params);
	public AssetPurchaseBill load(Class<AssetPurchaseBill> c, Serializable id);
	public AssetPurchaseBill getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<AssetPurchaseBill> queryAll(Class<AssetPurchaseBill> c);
	public Page<AssetPurchaseBill> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public AssetPurchaseBill getByNo(Class<AssetPurchaseBill> c, String no);  
	public AssetPurchaseBill getByHql(String hql);
	public void delete(AssetPurchaseBill bill);
	public void update(AssetPurchaseBill bill);
	public Page<AssetPurchaseBill> find(QueryFilter filter);

}