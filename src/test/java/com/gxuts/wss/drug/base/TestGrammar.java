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


public class TestGrammar {
	
	public static void say( ){
		try {
			System.out.println("try");
		} catch (Exception e) {
			
		}finally{
			System.out.println("finaly");
		}
	}
	
	
	


	private static void mysqlJdbc() {
		List<String> list=new ArrayList<String>(1);
		Set set=new HashSet();
		Map map=new HashMap();
		map.put(null, "1");
		say();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/drug","root", "admin");
			Statement s=c.createStatement();
			ResultSet r=s.executeQuery("select * from druginfo");
			while (r.next()) {
				int a=r.getInt(1);
				System.out.println(a);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 public static void main(String[] args) {
			
			try {
				System.out.println(Class.forName("UserInfo").newInstance());
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
		}

}
