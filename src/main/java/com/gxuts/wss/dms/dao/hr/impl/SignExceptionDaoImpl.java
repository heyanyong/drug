package com.gxuts.wss.dms.dao.hr.impl;

import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.hr.SignExceptionDao;
import com.gxuts.wss.dms.entity.hr.SignExceptionBill;

@Repository("signExceptionDao")
public class SignExceptionDaoImpl extends BaseDao<SignExceptionBill> implements SignExceptionDao{
}
