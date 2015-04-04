package com.gxuts.wss.dms.dao.sys;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.sys.UrlInfo;

public interface UrlDao {
	public Serializable save(UrlInfo url);
	public UrlInfo get(Class<UrlInfo> c, Serializable id);
	public List<UrlInfo> queryAll(Class<UrlInfo> c);
	public Page<UrlInfo> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public void delete(UrlInfo url);
	public void update(UrlInfo url);

}
