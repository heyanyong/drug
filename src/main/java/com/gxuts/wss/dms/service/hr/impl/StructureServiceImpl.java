package com.gxuts.wss.dms.service.hr.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.dao.hr.StructureDao;
import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.service.hr.StructureService;
@Service("structureService")
@Transactional
public class StructureServiceImpl implements StructureService {
	@Autowired
	private StructureDao structureDao;

	@Override
	public Serializable save(StructureInfo structure) {
		return structureDao.save(structure);
		
	}

}
