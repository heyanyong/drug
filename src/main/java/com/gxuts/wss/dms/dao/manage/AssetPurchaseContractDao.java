package com.gxuts.wss.dms.dao.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.manage.AssetPurchaseContractBill;
import com.gxuts.wss.dms.util.QueryFilter;

public interface AssetPurchaseContractDao {
	public Serializable save(AssetPurchaseContractBill bill);
	public AssetPurchaseContractBill get(Class<AssetPurchaseContractBill> c, Serializable id);
	public AssetPurchaseContractBill get(String hql, Map<String, Object> params);
	public AssetPurchaseContractBill load(Class<AssetPurchaseContractBill> c, Serializable id);
	public AssetPurchaseContractBill getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<AssetPurchaseContractBill> queryAll(Class<AssetPurchaseContractBill> c);
	public Page<AssetPurchaseContractBill> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public AssetPurchaseContractBill getByNo(Class<AssetPurchaseContractBill> c, String no);  
	public AssetPurchaseContractBill getByHql(String hql);
	public void delete(AssetPurchaseContractBill bill);
	public void update(AssetPurchaseContractBill bill);
	public Page<AssetPurchaseContractBill> find(QueryFilter filter);

}