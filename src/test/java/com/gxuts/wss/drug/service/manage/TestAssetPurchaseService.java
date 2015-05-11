package com.gxuts.wss.drug.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.manage.AssetInfo;
import com.gxuts.wss.dms.entity.manage.AssetPurchaseBill;
import com.gxuts.wss.dms.service.manage.AssetPurchaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TestAssetPurchaseService {
	@Autowired
	private AssetPurchaseService assetPurchaseService;
	
	@Test
	public void testSave(){
		AssetPurchaseBill bill=new AssetPurchaseBill("ap1");
		List<AssetInfo> items=new ArrayList<AssetInfo>();
		items.add(new AssetInfo("i1"));
		bill.setItems(items);
		assetPurchaseService.save(bill);
	}
	@Test
	public void delete(){
		assetPurchaseService.delete(new AssetPurchaseBill(2));
	}
}
