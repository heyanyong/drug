package com.gxuts.wss.dms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuts.wss.dms.base.Page;

public class BaseDao<T> implements BaseDaoI<T> {
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
	public T getByNo(Class<T> c, String no){
		Criteria criteria=getSession().createCriteria(c);
		List l=criteria.add(Restrictions.eq("no", no)).list();
		if (l != null && l.size() > 0) {
			return (T) l.get(0);
		}
		return null;  
	}
	public T getByHql(String hql){
		Query q = this.getSession().createQuery(hql);
		List<T> l=q.list();
		if (l != null && l.size() > 0) {
			return (T) l.get(0);
		}
		return null;  
	}
	public void delete(T t){
		getSession().delete(t);
	}
	
	public void update(T t){
		getSession().update(t);
	}
	
	public int executeHql(String hql) {
		Query q = this.getSession().createQuery(hql);
		return q.executeUpdate();
	}

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
	
	@SuppressWarnings("unchecked")
	public Page<T> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) {
		Page<T> page=new Page<T>();
		Query q = this.getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		page.setTotal(q.list().size());
		if(currentPage==null||rows==null){
			page.setData(q.list());
		}else{
			page.setData(q.setFirstResult((currentPage - 1) * rows).setMaxResults(rows).list());
		}
		return page;
	}
	


}
