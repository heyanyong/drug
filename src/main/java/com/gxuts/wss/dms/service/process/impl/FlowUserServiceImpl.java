package com.gxuts.wss.dms.service.process.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.dao.hr.StructureDao;
import com.gxuts.wss.dms.dao.hr.UserDao;
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.service.process.FlowUserService;

 
@Service("flowUserService")
@Transactional
public class FlowUserServiceImpl implements FlowUserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private StructureDao structureDao;

	
	@Override
	public UserInfo departmentOneRole(int departmentId,String roleName) {
		UserInfo user=userDao.departmentOneRole(departmentId,roleName);
		return user;
	}


	@Override
	public List<UserInfo> manyByRole(String roleName) {
		return userDao.manyByRole(roleName);
	}


	@Override
	public UserInfo leaderOneRole(int departmentId, String roleName) {
		UserInfo user=null;
		StructureInfo dept=structureDao.get(StructureInfo.class, departmentId);
		if(dept==null){
			return null;
		}else {
			  user=departmentOneRole(departmentId, roleName);
			if(user==null){
			  user= leaderOneRole(dept.getpId(), roleName);
			}
		}
		return user;
	}

 
 

	 

}
