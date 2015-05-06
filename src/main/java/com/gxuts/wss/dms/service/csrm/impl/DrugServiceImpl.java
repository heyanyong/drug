package com.gxuts.wss.dms.service.csrm.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.csrm.DrugDao;
import com.gxuts.wss.dms.entity.csrm.DrugInfo;
import com.gxuts.wss.dms.entity.csrm.ExportBill;
import com.gxuts.wss.dms.entity.csrm.ExportDrug;
import com.gxuts.wss.dms.entity.csrm.PurchaseBill;
import com.gxuts.wss.dms.service.csrm.DrugService;
import com.gxuts.wss.dms.util.DateUtil;
@Service("drugService")
@Transactional
public class DrugServiceImpl implements DrugService {
	@Autowired
	private DrugDao drugDao;

	@Override
	public Serializable save(DrugInfo drug) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(DrugInfo drug) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DrugInfo drug) {
		drugDao.update(drug);
	}

	@Override
	public DrugInfo get(Class<DrugInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return drugDao.get(c, id);
	}

	@Override
	public int executeHql(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DrugInfo> queryAll(Class<DrugInfo> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrugInfo load(Class<DrugInfo> c, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrugInfo get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrugInfo getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DrugInfo> query(String hql, Map<String, Object> params,
			Integer currentPage, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}
	//【[8]天数预警==1】;【[9]数量预警==1】
	@Override
	public Page<Object[]> queryDrugList(Map<String, Object> params,
			Integer currentPage, Integer numPerPage) {
		Page<Object[]> page =drugDao.queryDrugList( params, currentPage, numPerPage);
		List<Object[]> data1=page.getData();
		List<Object[]> data2=new ArrayList<Object[]>();
		for (int i = 0; i < data1.size(); i++) {
			Object[] row=data1.get(i);
			int pm=Integer.parseInt(row[2].toString());
			int em=Integer.parseInt(row[3].toString());
			int alertNum=Integer.parseInt(row[9].toString());
			Date endDate=DateUtil.string2Date(row[6].toString(), "yyyy-MM-dd");
			int remainDay=DateUtil.daysBetween(new Date(), endDate);
			int alertDay=Integer.parseInt(row[8].toString());
			if(pm>em){
				row[8]=(remainDay<=alertDay&&alertDay>0)? 1:0;
				row[9]=(pm-em)<=alertNum? 1:0;
				row[10]=remainDay<0? 1:0;
				data2.add(row);
			}
		}
		page.setData(data2);
		return page;
	}

	@Override
	public PurchaseBill toPurchase(String ids) {
		PurchaseBill p=new PurchaseBill();
		List<DrugInfo> drugs=new ArrayList<DrugInfo>();
		String[] idArr=ids.split(",");
		for (int i = 0; i < idArr.length; i++) {
			Integer id=Integer.parseInt(idArr[i]);
			DrugInfo d=drugDao.get(DrugInfo.class, id);
			drugs.add(d);
		}
		p.setDrugs(drugs);
		return p;
	}

	@Override
	public ExportBill toExport(String ids) {
		ExportBill export=new ExportBill();
		List<ExportDrug> exportDrugs=new ArrayList<ExportDrug>();
		String[] idArr=ids.split(",");
		for (int i = 0; i < idArr.length; i++) {
			Integer id=Integer.parseInt(idArr[i]);
			DrugInfo d=drugDao.get(DrugInfo.class, id);
			ExportDrug ed=new ExportDrug();
			ed.setName(d.getName());
			ed.setDrugId(d.getId());
			exportDrugs.add(ed);
		}
		export.setExportDrugs(exportDrugs);
		return export;
	}

	 

	 
	 

}
