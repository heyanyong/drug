package com.gxuts.wss.dms.dao.manage;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.manage.ArticleInfo;

public interface ArticleDao {
	public Serializable save(ArticleInfo article);
	public ArticleInfo get(Class<ArticleInfo> c, Serializable id);
	public ArticleInfo get(String hql, Map<String, Object> params);
	public ArticleInfo load(Class<ArticleInfo> c, Serializable id);
	public ArticleInfo getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<ArticleInfo> queryAll(Class<ArticleInfo> c);
	public Page<ArticleInfo> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public ArticleInfo getByNo(Class<ArticleInfo> c, String no);  
	public ArticleInfo getByHql(String hql);
	public void delete(ArticleInfo article);
	public void update(ArticleInfo article);

}
