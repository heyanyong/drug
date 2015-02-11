package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.hr.SignDao;
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.hr.SignService;
import com.gxuts.wss.dms.service.hr.UserService;

@Service("signService")
@Transactional
public class SignServiceImpl implements SignService {
	@Autowired
	private SignDao signDao;
	@Autowired
	private UserService userService;

	@Override
	public SignInfo get(Class<SignInfo> c, Serializable id) {
		return signDao.get(c, id);
	}

	@Override
	public void delete(SignInfo sign) {
		signDao.delete(sign);
	}

	@Override
	public void update(SignInfo sign) {
		signDao.update(sign);
	}

	@Override
	public int executeHql(String hql) {
		return signDao.executeHql(hql);
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		return 0;
	}

	@Override
	public List<SignInfo> queryAll(Class<SignInfo> c) {
		return null;
	}

	@Override
	public SignInfo load(Class<SignInfo> c, Serializable id) {
		return null;
	}

	@Override
	public SignInfo get(String hql, Map<String, Object> params) {
		return null;
	}

	@Override
	public SignInfo getObject(String hql, Object[] params) {
		return null;
	}

	@Override
	public Page<SignInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		return signDao.query(hql, params, currentPage, rows);
	}

	// 是否用本类方法?
	@Override
	public Serializable save(String userNo, Date recordDate, Date signDate) {
		// 查询是否已有
		SignInfo exitSign = getByRecord(userNo, recordDate);
		// 如果有，对比sign置换保存实体存入。如果没有signDate 当signIn 存入
		if (exitSign == null) {
			UserInfo user = userService.getByNo(UserInfo.class, userNo);
			SignInfo sign = new SignInfo();
			sign.setDepartmentName(user.getStructure().getName());
			sign.setUserName(user.getName());
			sign.setUserNo(user.getNo());
			sign.setRecordDate(recordDate);
			sign.setSignIn(signDate);
			return signDao.save(sign);
		} else if (exitSign.getSignIn().before(signDate)) {
			exitSign.setSignOut(signDate);
			signDao.update(exitSign);
			return exitSign;
		} else if (exitSign.getSignIn().after(signDate)) {
			Date date3 = exitSign.getSignIn();
			exitSign.setSignIn(signDate);
			exitSign.setSignOut(date3);
			signDao.update(exitSign);
			return exitSign;
		} else {
			return null;
		}
	}

	@Override
	public SignInfo getByHql(String hql) {
		return signDao.getByHql(hql);
	}

	@Override
	public SignInfo getByRecord(String userNo, Date recordDate) {
		return signDao.getByRecord(userNo, recordDate);
	}

	@Override
	public Serializable save(SignInfo sign) {
		return signDao.save(sign);
	}

}
