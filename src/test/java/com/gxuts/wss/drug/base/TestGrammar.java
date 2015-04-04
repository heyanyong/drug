package com.gxuts.wss.drug.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.util.DateUtil;


public class TestGrammar {
	
	public static void say( ){
		try {
			System.out.println("try");
		} catch (Exception e) {
			
		}finally{
			System.out.println("finaly");
		}
	}
	
	
	


		 
	 public static void main(String[] args) {
			Set<String> set=new HashSet<String>();
			set.add("11");
			set.add("12");
			set.add("11");
			for(String id:set){
				System.out.println(id);
			}
			
		}

}
