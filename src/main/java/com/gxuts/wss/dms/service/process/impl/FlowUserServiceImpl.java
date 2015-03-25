package com.gxuts.wss.dms.service.process.impl;

import java.util.ArrayList;
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
	public List<String> manyByRole(String roleName) {
		List<UserInfo> users=userDao.manyByRole(roleName);
		List<String> nos=new ArrayList<String>(users.size());
		for (UserInfo user:users) {
			nos.add(user.getNo());
		}
		return nos;
	}


	@Override
	public String leaderByRole(int departmentId, String roleName) {
		UserInfo user=null;
		String no=null;
		StructureInfo dept=structureDao.get(StructureInfo.class, departmentId);
		if(dept==null){
			return null;
		}else {
			  user=userDao.departmentOneRole(departmentId, roleName);
			if(user!=null){
				no=user.getNo();
			}else{
				no= leaderByRole(dept.getpId(), roleName);
			}
		}
		return no;
	}


	@Override
	public  String  oneByRole(String roleName) {
		List<UserInfo> users=userDao.manyByRole(roleName);
		return users==null? null:users.get(0).getNo();
	}

}
