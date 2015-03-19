package com.gxuts.wss.drug.util;

import org.junit.Test;

import com.gxuts.wss.dms.util.MysqlUtil;

public class TestMysql {
	@Test
	public void getDepartmentAndRole(){
		MysqlUtil mu=new MysqlUtil();
		String no=mu.getDepartmentAndRole(5, "经理");
		System.out.println(no);
		System.out.println(mu.getPid(8));
	}
	@Test
	public void getPid(){
		MysqlUtil mu=new MysqlUtil();
		System.out.println(mu.getPid(1));
	}
	@Test
	public void getOneRole(){
		MysqlUtil mu=new MysqlUtil();
		System.out.println(mu.getOneRole("经理"));
	}
	@Test
	public void getLeaderOndRole(){
		MysqlUtil mu=new MysqlUtil();
		String no=mu.getLeaderOndRole(11, "经理");
		System.out.println(no);
	}
}
