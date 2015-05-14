package com.gxuts.wss.dms.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.util.QueryFilter;

public class BaseDao<T> implements BaseDaoI<T> {
	private final String hql;// 查询语句
	private final Class<T> entityClass;// 泛型类的class
	private static final String JOINFETCH = " LEFT JOIN FETCH ";// 预先抓取关键字
	private static final String JOIN = " LEFT JOIN ";// 级联查询关键字
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public BaseDao(){
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.hql = " SELECT DISTINCT t FROM " + this.entityClass.getSimpleName()+" t";// select DISTINCT t from Txxx t
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public  Page<T> find(QueryFilter filter) {
		return this.find(filter, this.getHql());
	}
	
	private  Page<T> find(QueryFilter filter, String newHql) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = newHql;
		hql = changeHqlAndParams(filter, params, hql);
		if (StringUtils.isNotBlank(filter.getSort())) {// 如果有排序需求，这拼装排序条件
			hql += " ORDER BY " + filter.getSort();
		}
		return this.find(hql, params, filter.getPage(), filter.getPageSize());
	}
	public Page<T> find(String hql, Map<String, Object> params, Integer currentPage, Integer pageSize) {
		Query q = getSession().createQuery(hql+" order by id desc");
		Page<T> page=new Page<T>();
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		if (currentPage == null || pageSize == null) {
			page.setData(q.list());
			return page;
		}
		page.setTotalCount(q.list().size());
		page.setData( q.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list());
		page.setCurrentPage(currentPage);
		page.setNumPerPage(pageSize);
		page.setPageNumShown(5);
		 return page;
	}
	public Serializable save(T t){
		return getSession().save(t);
	}
	public void saveOrUpdate(T t){
		 getSession().saveOrUpdate(t);
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
		Query q = getSession().createQuery(hql);
		return q.executeUpdate();
	}

	public int executeHql(String hql, Map<String, Object> params) {
		Query q =  getSession().createQuery(hql);
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
		Query q =  getSession().createQuery(hql);
		
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
		Query q =  getSession().createQuery(hql);
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
	public Page<Object[]> queryField(String hql, Map<String, Object> params, Integer currentPage, Integer numPerPage) {
		if(currentPage==null){
			currentPage=1;
		}
		if(numPerPage==null){
			numPerPage=17;
		}
		Query q =  getSession().createQuery(hql);
		List list=q.list();
		Page<Object[]> page=new Page<Object[]>();
		page.setTotalCount(list.size());
		page.setData(q.setFirstResult((currentPage - 1) * numPerPage).setMaxResults(numPerPage).list());
		page.setPageNumShown(5);
		page.setCurrentPage(currentPage);
		page.setNumPerPage(numPerPage);
		return page;
	}
	
	
	@SuppressWarnings("unchecked")
	public Page<T> query(String hql, Map<String, Object> params, Integer currentPage, Integer numPerPage) {
		currentPage=currentPage==null? 1:currentPage; 
		numPerPage=numPerPage==null? 17:numPerPage;
		Page<T> page=new Page<T>();
		Query q =  getSession().createQuery(hql+" order by id desc");
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		page.setTotalCount(q.list().size());
		page.setData(q.setFirstResult((currentPage - 1) * numPerPage).setMaxResults(numPerPage).list());
		page.setPageNumShown(5);
		page.setCurrentPage(currentPage);
		page.setNumPerPage(numPerPage);
		return page;
	}
	
	public String queryOneField(String hql){
		Query q =  getSession().createQuery(hql);
		List<Object> list=q.list();
		if(list!=null&&list.size()>0){
			return  list.get(0)+"";
		}else{
			return null;
		}
	}
	public String getHql() {
		return hql;
	}
	public String changeHqlAndParams(QueryFilter filter, Map<String, Object> params, String hql) {
		if (filter.getJoinFetch() != null && filter.getJoinFetch().length > 0) {// 如果有预先抓取需求，这拼装hql
			for (String joinFetch : filter.getJoinFetch()) {
				hql += " " + JOINFETCH + " " + joinFetch + " AS " + joinFetch.substring(joinFetch.indexOf(".") + 1) + " ";// left join fetch t.company as company
			}
		}
		if (filter.getJoin() != null && filter.getJoin().length > 0) {// 如果有关联需要，拼装hql
			for (String join : filter.getJoin()) {
				hql += " " + JOIN + " " + join + " AS " + join.substring(join.indexOf(".") + 1) + " ";// left join t.company as company
			}
		}
		hql += " WHERE 1=1 ";
		if (filter.getParams().size() > 0) {
			int paramIndex = 0;// 参数占位符索引
			for (Object[] o : filter.getParams()) {// filter.getParams()=[["t.name", "like", "%%孙%%"],["id", "in", [1, 2, 3, 4]]]
				if (o[1].toString().equalsIgnoreCase("In") || o[1].toString().equalsIgnoreCase("Not In")) {// In条件拼装，最终会拼装成类似 and id in (:_1,:_2,:_3,:_4)
					List<Object> values = (ArrayList<Object>) o[2];
					String inParamString = "";
					for (int i = 0; i < values.size(); i++) {
						if (i > 0) {
							inParamString += " , ";
						}
						++paramIndex;// 增加参数占位符索引
						String paramName = "_" + paramIndex;
						inParamString += " :" + paramName + " ";
						params.put(paramName, values.get(i));
					}
					if (o[1].toString().equalsIgnoreCase("In")) {
						hql += " AND " + o[0] + " IN (" + inParamString + ") ";
					}
					if (o[1].toString().equalsIgnoreCase("Not In")) {
						hql += " AND " + o[0] + " NOT IN (" + inParamString + ") ";
					}
				} else if (o[1].toString().equalsIgnoreCase("Is Null")) {// is null条件拼装
					hql += " AND " + o[0] + " IS NULL ";
				} else if (o[1].toString().equalsIgnoreCase("Is Not Null")) {// is not null条件拼装
					hql += " AND " + o[0] + " IS NOT NULL ";
				} else {
					++paramIndex;// 增加参数占位符索引
					String paramName = "_" + paramIndex;
					hql += " AND " + o[0] + " " + o[1] + " :" + paramName + " ";
					params.put(paramName, o[2]);
				}
			}
		}
		return hql;
	}

}
