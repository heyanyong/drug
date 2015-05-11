package com.gxuts.wss.dms.service.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.manage.AssetInfo;

public interface AssetService {
	public Serializable save(AssetInfo asset);
	public AssetInfo get(Class<AssetInfo> c, Serializable id);
	public AssetInfo get(String hql, Map<String, Object> params);
	public AssetInfo load(Class<AssetInfo> c, Serializable id);
	public AssetInfo getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<AssetInfo> queryAll();
	public Page<AssetInfo> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public AssetInfo getByNo(Class<AssetInfo> c, String no);  
	public AssetInfo getByHql(String hql);
	public void delete(AssetInfo asset);
	public void update(AssetInfo asset);
}
