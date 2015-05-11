package com.gxuts.wss.dms.service.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.manage.NoticeInfo;

public interface NoticeService {
	public Serializable save(NoticeInfo info);
	public NoticeInfo get(Class<NoticeInfo> c, Serializable id);
	public NoticeInfo get(String hql, Map<String, Object> params);
	public NoticeInfo load(Class<NoticeInfo> c, Serializable id);
	public NoticeInfo getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<NoticeInfo> queryAll();
	public Page<NoticeInfo> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public NoticeInfo getByNo(Class<NoticeInfo> c, String no);  
	public NoticeInfo getByHql(String hql);
	public void delete(NoticeInfo info);
	public void update(NoticeInfo info);
}
