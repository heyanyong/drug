package com.gxuts.wss.drug.service.hr.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.drug.dao.hr.RoleDao;
import com.gxuts.wss.drug.dao.hr.StructureDao;
import com.gxuts.wss.drug.entity.RoleInfo;
import com.gxuts.wss.drug.entity.StructureInfo;
import com.gxuts.wss.drug.service.hr.RoleService;
import com.gxuts.wss.drug.service.hr.StructureService;
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public Serializable save(RoleInfo role) {
		return roleDao.save(role);
		
	}

	@Override
	public RoleInfo get(Class<RoleInfo> c, Serializable id) {
		 
		return null;
	}

}
