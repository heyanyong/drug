package com.gxuts.wss.dms.dao.sys;

import java.io.Serializable;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.CustomerInfo;
import com.gxuts.wss.dms.entity.sys.ControllerLog;

public interface ControllerLogDao {
	public Serializable save(ControllerLog controllerLog);
	public ControllerLog  get(Class<ControllerLog> c, Serializable id);
	public Page<ControllerLog> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
}
