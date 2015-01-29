package com.gxuts.wss.dms.dao.hr.impl;


import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.hr.UserDao;
import com.gxuts.wss.dms.entity.hr.UserInfo;
@Repository("userDao")
public class UserDaoImpl extends BaseDao<UserInfo> implements UserDao{


}
