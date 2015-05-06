package com.gxuts.wss.dms.service.csrm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.csrm.ExportBill;

public interface ExportService {
	public Serializable save(ExportBill exportBill);

	public void delete(ExportBill exportBill);

	public void update(ExportBill exportBill);
	public ExportBill get(Class<ExportBill> c, Serializable id);

	public int executeHql(String hql);

	public int executeHql(String hql, Map<String, Object> params);

	public List<ExportBill> queryAll(Class<ExportBill> c);

	public ExportBill load(Class<ExportBill> c, Serializable id);

	public ExportBill get(String hql, Map<String, Object> params);

	public ExportBill getObject(String hql, Object[] params);

	public Page<ExportBill> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows);
	
	public ExportBill createExport();
	
}
