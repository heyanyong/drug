package com.gxuts.wss.dms.service.sys.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.sys.ControllerLogDao;
import com.gxuts.wss.dms.entity.sys.ControllerLog;
import com.gxuts.wss.dms.service.sys.ControllerLogService;


/**
 * ControllerLogServiceImpl
 */
@Service("controllerLogService")
public class ControllerLogServiceImpl  implements ControllerLogService {
	@Autowired
	private ControllerLogDao controllerLogDao;
	
	@Override
	public Serializable save(ControllerLog controllerLog) {
		return controllerLogDao.save(controllerLog);
	}
	@Override
	public ControllerLog get(Class<ControllerLog> c, Serializable id) {
		return controllerLogDao.get(c, id);
	}
	@Override
	public Page<ControllerLog> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return controllerLogDao.query("from ControllerLog", params, currentPage, rows);
	}

}
