package com.gxuts.wss.dms.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.sys.ControllerLogDao;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.ControllerLog;
@Repository("controllerLogDao")
public class ControllerLogDaoImpl extends BaseDao<ControllerLog> implements ControllerLogDao {
}
