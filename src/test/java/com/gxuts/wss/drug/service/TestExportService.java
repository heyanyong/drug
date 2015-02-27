package com.gxuts.wss.drug.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gxuts.wss.dms.entity.business.ExportBill;
import com.gxuts.wss.dms.entity.hr.SignInfo;
import com.gxuts.wss.dms.service.business.ExportService;
import com.gxuts.wss.dms.service.hr.SignService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:/spring/applicationContext.xml"})
public class TestExportService {
	@Autowired
	private ExportService exportService;
	
	@Test
	public void testCreateBill(){
		  ExportBill bill=exportService.createExport();
		  System.out.println(bill);
		  exportService.save(bill);
	}
}
