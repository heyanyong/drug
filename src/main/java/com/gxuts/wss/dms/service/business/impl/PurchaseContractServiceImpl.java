package com.gxuts.wss.dms.service.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.dao.business.PurchaseContractDao;
import com.gxuts.wss.dms.dao.business.PurchaseDao;
import com.gxuts.wss.dms.entity.business.PurchaseBill;
import com.gxuts.wss.dms.entity.business.PurchaseContractBill;
import com.gxuts.wss.dms.service.business.PurchaseContractService;
import com.gxuts.wss.dms.service.business.PurchaseService;
@Service("purchaseContractService")
@Transactional
public class PurchaseContractServiceImpl implements PurchaseContractService {

	@Autowired
	private PurchaseDao purchaseDao;
	@Autowired
	private PurchaseContractDao purchaseContractDao;
	@Override
	public Serializable save(PurchaseContractBill contract) {
		return purchaseContractDao.save(contract);
	}

	@Override
	public void delete(PurchaseContractBill contract) {
		purchaseContractDao.delete(contract);
	}

	@Override
	public void update(PurchaseContractBill contract) {
		purchaseContractDao.update(contract);
	}

	@Override
	public PurchaseContractBill get(Class<PurchaseContractBill> c,
			Serializable id) {
		return purchaseContractDao.get(c, id);
	}
	//需要产生采购（未保存状态）
	public PurchaseContractBill fromPurchase(Integer purchaseId){
		PurchaseContractBill contract=new PurchaseContractBill();
		PurchaseBill purchase=purchaseDao.get(PurchaseBill.class, purchaseId);
		contract.setDrugs(purchase.getDrugs());
		return contract;
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
	public List<PurchaseContractBill> queryAll(Class<PurchaseContractBill> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseContractBill load(Class<PurchaseContractBill> c,
			Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseContractBill get(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PurchaseContractBill getObject(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PurchaseContractBill> query(String hql,
			Map<String, Object> params, Integer currentPage, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 
	 

}
