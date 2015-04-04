package com.gxuts.wss.dms.dao.hr.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.hr.RoleDao;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.sys.UrlInfo;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDao<RoleInfo> implements RoleDao{

	@Override
	public List<UrlInfo> queryUrlAll(Class<UrlInfo> c) {
		@SuppressWarnings("unchecked")
		List<UrlInfo> list=this.getSession().createCriteria(c).list();
		return list;
	}

 

}
