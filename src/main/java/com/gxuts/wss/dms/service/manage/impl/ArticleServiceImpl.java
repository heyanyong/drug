package com.gxuts.wss.dms.service.manage.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.manage.ArticleDao;
import com.gxuts.wss.dms.entity.manage.ArticleInfo;
import com.gxuts.wss.dms.service.manage.ArticleService;
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;

	@Override
	public Serializable save(ArticleInfo article) {
		return articleDao.save(article);
		
	}
	@Override
	public ArticleInfo get(Class<ArticleInfo> c, Serializable id) {
		return articleDao.get(c, id);
	}

	@Override
	public ArticleInfo get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public ArticleInfo load(Class<ArticleInfo> c, Serializable id) {
		return null;
	}

	@Override
	public ArticleInfo getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public List<ArticleInfo> queryAll() {
		return articleDao.queryAll(ArticleInfo.class);
	}

	@Override
	public Page<ArticleInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return articleDao.query("from ArticleInfo", params, currentPage, rows);
	}

	@Override
	public ArticleInfo getByNo(Class<ArticleInfo> c, String no) {
		return null;
	}

	@Override
	public ArticleInfo getByHql(String hql) {
		return null;
	}

	@Override
	public void delete(ArticleInfo article) {
		articleDao.delete(article);
	}

	@Override
	public void update(ArticleInfo article) {
		articleDao.update(article);
	}

}
