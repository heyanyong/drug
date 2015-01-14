package com.gxuts.wss.drug.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.gxuts.wss.drug.base.Page;

public interface BaseDaoI<T> {

	public Session getSession();

	public Serializable save(T t);

	public T get(Class<T> c, Serializable id);

	public void delete(T t);

	public void update(T t);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<T> queryAll(Class<T> c);

	public T load(Class<T> c, Serializable id);

	public T get(String hql, Map<String, Object> params);

	public T getObject(String hql, Object[] params);

	public Page<T> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);

}