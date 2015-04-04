package com.gxuts.wss.dms.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.sys.UrlDao;
import com.gxuts.wss.dms.entity.sys.UrlInfo;
@Repository("urlDao")
public class UrlDaoImpl extends BaseDao<UrlInfo> implements UrlDao{
}
