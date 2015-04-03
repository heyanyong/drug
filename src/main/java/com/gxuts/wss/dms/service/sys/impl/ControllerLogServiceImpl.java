package com.gxuts.wss.dms.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxuts.wss.dms.dao.sys.ControllerLogDao;
import com.gxuts.wss.dms.entity.sys.ControllerLog;
import com.gxuts.wss.dms.service.sys.ControllerLogService;


/**
 * ControllerLogServiceImpl
 * 
 * http://git.oschina.net/sphsyv/sypro
 *
 * @author 孙宇
 *
 */
@Service("controllerLogService")
public class ControllerLogServiceImpl  implements ControllerLogService {
	@Autowired
	private ControllerLogDao controllerLogDao;
	@Override
	public void save(ControllerLog controllerLog) {
		controllerLogDao.save(controllerLog);
	}


}
