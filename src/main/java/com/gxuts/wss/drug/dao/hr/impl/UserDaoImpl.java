package com.gxuts.wss.drug.dao.hr.impl;


import org.springframework.stereotype.Repository;

import com.gxuts.wss.drug.dao.BaseDao;
import com.gxuts.wss.drug.dao.hr.UserDao;
import com.gxuts.wss.drug.entity.hr.UserInfo;
@Repository("userDao")
public class UserDaoImpl extends BaseDao<UserInfo> implements UserDao{


}
