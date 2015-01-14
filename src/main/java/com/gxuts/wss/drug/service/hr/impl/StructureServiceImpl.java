package com.gxuts.wss.drug.service.hr.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.drug.dao.hr.StructureDao;
import com.gxuts.wss.drug.entity.hr.StructureInfo;
import com.gxuts.wss.drug.service.hr.StructureService;
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
