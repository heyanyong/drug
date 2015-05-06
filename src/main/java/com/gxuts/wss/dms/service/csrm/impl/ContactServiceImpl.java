package com.gxuts.wss.dms.service.csrm.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.csrm.ContactDao;
import com.gxuts.wss.dms.entity.csrm.ContactInfo;
import com.gxuts.wss.dms.service.csrm.ContactService;

 
@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDao contactDao;

	@Override
	public Serializable save(ContactInfo contact) {
		return null;
	}

	@Override
	public void delete(ContactInfo contact) {
		
	}

	@Override
	public void update(ContactInfo contact) {
		
	}

	@Override
	public ContactInfo get(Class<ContactInfo> c, Serializable id) {
		return null;
	}

	@Override
	public int executeHql(String hql) {
		return 0;
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		return 0;
	}

	@Override
	public List<ContactInfo> queryAll(Class<ContactInfo> c) {
		return null;
	}

	@Override
	public ContactInfo load(Class<ContactInfo> c, Serializable id) {
		return null;
	}

	@Override
	public ContactInfo get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public ContactInfo getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public Page<ContactInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return null;
	}

	 

}
