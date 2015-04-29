package com.gxuts.wss.drug.service.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.base.Page;
import com.gxuts.wss.dms.entity.business.DrugInfo;
import com.gxuts.wss.dms.entity.hr.RoleInfo;
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.service.business.DrugService;
import com.gxuts.wss.dms.service.hr.SignService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestDrugService {
	@Autowired
	private DrugService drugService;
	
	@Test
	 public void testDrugUpdate(){
		DrugInfo drug=new DrugInfo(1);
		drug.setName("newName");
		drugService.update(drug);
		
	}
	//查列表
	@Test 
	public void drugList(){
		Page<Object[]> page=drugService.queryDrugList(null, null, null);
		List<Object[]> list=page.getData();
		for (int i = 0; i < list.size(); i++){
			for (int j = 0; j < list.get(i).length; j++) {
				System.out.print(list.get(i)[j]+"  ");
			}
			
			System.out.println();
		}
	}
	 
	@Test
	public void testToPurchase(){
		String ids="1,2,3";
		drugService.toPurchase(ids);
	}
} 
