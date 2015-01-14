package com.gxuts.wss.drug.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mvel2.ast.WithNode.ParmValuePair;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public Serializable save(T t){
		return getSession().save(t);
	}
	@SuppressWarnings("unchecked")
	public T get(Class<T> c, Serializable id){
		return (T) getSession().get(c,id);
	}
	public void delete(T t){
		getSession().delete(t);
	}
	
	public void update(T t){
		getSession().update(t);
	}
	/**
	 * 执行一条HQL语句
	 * @param hql HQL语句
	 * @return 响应结果数目
	 */
	public int executeHql(String hql) {
		Query q = this.getSession().createQuery(hql);
		return q.executeUpdate();
	}

	/**
	 * 执行一条HQL语句
	 * @param hql HQL语句
	 * @param params 参数
	 * @return 响应结果数目
	 */
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = this.getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> queryAll(Class<T> c){
		return getSession().createCriteria(c).list();
	}
	
	@SuppressWarnings("unchecked")
	public T load(Class<T> c,Serializable id){
		return (T) getSession().load(c, id);
	}
	
	
	/**
	 * 通过HQL语句获取一个对象
	 * @param hql HQL语句
	 * @param params 参数
	 * @return 对象
	 */
	public T get(String hql, Map<String, Object> params) {
		Query q = this.getSession().createQuery(hql);
		
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;  
	}
	/**
	 * 通过HQL语句获取一个对象
	 * @param hql HQL语句
	 * @param params 参数
	 * @return 对象
	 */
	@SuppressWarnings("unchecked")
	public T getObject(String hql,  Object[] params) {
		Query q = this.getSession().createQuery(hql);
		if(params!=null && params.length>0){
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;  
	}

}
