package com.gxuts.wss.dms.dao.business.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.business.DrugDao;
import com.gxuts.wss.dms.entity.business.DrugInfo;

 
@Repository("drugDao")
public class DrugDaoImpl extends BaseDao<DrugInfo> implements DrugDao{

	public Page<Object[]> queryDrugList(Map<String, Object> params, Integer currentPage, Integer numPerPage) {
		if(currentPage==null){
			currentPage=1;
		}
		if(numPerPage==null){
			numPerPage=17;
		}
		String sql="SELECT d.id,d.`name`,"
				+ "d.purchaseNumber,(SELECT SUM(exportNum)  from exportdrug e  WHERE d.id=e.drugId GROUP BY e.drugId ) as em,"
				+ "d.unit,d.productDate,d.endDate,d.createDate,"
				+ "d.alertDay,d.alertNumber,d.contract_id  from druginfo d "
				+ "where 1=1";
		Query q =  getSession().createSQLQuery(sql);
		List list=q.list();
		Page<Object[]> page=new Page<Object[]>();
		page.setTotalCount(list.size());
		page.setData(q.setFirstResult((currentPage - 1) * numPerPage).setMaxResults(numPerPage).list());
		page.setPageNumShown(5);
		page.setCurrentPage(currentPage);
		page.setNumPerPage(numPerPage);
		return page;
	}
}
