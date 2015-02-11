package com.gxuts.wss.dms.dao.business;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.ContactInfo;

public interface ContactDao {
	public Serializable save(ContactInfo contact);

	public void delete(ContactInfo contact);

	public void update(ContactInfo contact);
	public ContactInfo get(Class<ContactInfo> c, Serializable id);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<ContactInfo> queryAll(Class<ContactInfo> c);

	public ContactInfo load(Class<ContactInfo> c, Serializable id);

	public ContactInfo get(String hql, Map<String, Object> params);

	public ContactInfo getObject(String hql, Object[] params);

	public Page<ContactInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
