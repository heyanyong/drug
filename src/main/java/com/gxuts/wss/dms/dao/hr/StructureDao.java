package com.gxuts.wss.dms.dao.hr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.hr.StructureInfo;

public interface StructureDao {

	public Serializable save(StructureInfo structure);
	public StructureInfo get(Class<StructureInfo> c, Serializable id);
	public StructureInfo get(String hql, Map<String, Object> params);
	public StructureInfo load(Class<StructureInfo> c, Serializable id);
	public StructureInfo getObject(String hql,  Object[] params);
	public int executeHql(String hql);
	public List<StructureInfo> queryAll(Class<StructureInfo> c);
	public Page<StructureInfo> query(String hql, Map<String, Object> params, Integer currentPage, Integer rows) ;
	public StructureInfo getByNo(Class<StructureInfo> c, String no);  
	public StructureInfo getByHql(String hql);
	public void delete(StructureInfo structure);
	public void update(StructureInfo structure);

}
