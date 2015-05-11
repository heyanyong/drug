package com.gxuts.wss.dms.service.manage.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.manage.NoticeDao;
import com.gxuts.wss.dms.entity.manage.NoticeInfo;
import com.gxuts.wss.dms.service.manage.NoticeService;
@Service("noticeService")
@Transactional
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	@Override
	public Serializable save(NoticeInfo notice) {
		return noticeDao.save(notice);
		
	}
	@Override
	public NoticeInfo get(Class<NoticeInfo> c, Serializable id) {
		return noticeDao.get(c, id);
	}

	@Override
	public NoticeInfo get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public NoticeInfo load(Class<NoticeInfo> c, Serializable id) {
		return null;
	}

	@Override
	public NoticeInfo getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return noticeDao.executeHql(hql);
	}

	@Override
	public List<NoticeInfo> queryAll() {
		return noticeDao.queryAll(NoticeInfo.class);
	}

	@Override
	public Page<NoticeInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return noticeDao.query(hql, params, currentPage, rows);
	}

	@Override
	public NoticeInfo getByNo(Class<NoticeInfo> c, String no) {
		return null;
	}

	@Override
	public NoticeInfo getByHql(String hql) {
		return null;
	}

	@Override
	public void delete(NoticeInfo notice) {
		noticeDao.delete(notice);
	}

	@Override
	public void update(NoticeInfo notice) {
		noticeDao.update(notice);
	}

}
