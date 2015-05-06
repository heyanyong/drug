package com.gxuts.wss.dms.dao.business.impl;

import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.business.PayDao;
import com.gxuts.wss.dms.entity.business.PayBill;

@Repository("payDao")
public class PayDaoImpl extends BaseDao<PayBill> implements PayDao{

}
