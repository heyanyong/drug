package com.gxuts.wss.dms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MysqlUtil {
	public  Connection getConnection() {
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/drug?useUnicode=true&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,"root","admin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public String  getDepartmentAndRole(int departmentId,String roleName){
		Connection conn=this.getConnection();
		String userNo=null;
		String sql="SELECT uu.`no` from userinfo uu,roleinfo rr,userinfo_roleinfo ur where uu.id=ur.UserInfo_id and rr.id=ur.roles_id "
				+ "and structure_id='"+departmentId+"' and  rr.`name`='"+roleName+"'";
		try {
			Statement sta=conn.createStatement();
			ResultSet result=sta.executeQuery(sql);
			 if(result.next()){
				 userNo=result.getString(1);
			 }
			result.close();
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userNo;
	}
	public int getPid(int departmentId){
		Connection conn=this.getConnection();
		int pid=0;
		String sql="select pid FROM structureinfo where id="+departmentId;
		try {
			Statement sta=conn.createStatement();
			ResultSet result=sta.executeQuery(sql);
			 if(result.next()){
				 pid=result.getInt(1);
			 }
			result.close();
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pid;
	}
	
	public String getLeaderOndRole(int departmentId,String roleName){
		String userNo=this.getDepartmentAndRole(departmentId, roleName);
		int pid=getPid(departmentId);
		if(pid==0||(userNo!=null&&!"".equals(userNo))){
			return userNo;
		}else{
			return userNo=this.getLeaderOndRole(pid, roleName);
		}
	}
	public String getOneRole(String roleName){
		Connection conn=this.getConnection();
		String userNo=null;
		String sql="SELECT uu.`no` from userinfo uu,roleinfo rr,userinfo_roleinfo ur where uu.id=ur.UserInfo_id and rr.id=ur.roles_id "
				+ "and rr.`name`='"+roleName+"'";
		try {
			Statement sta=conn.createStatement();
			ResultSet result=sta.executeQuery(sql);
			 if(result.next()){
				 userNo=result.getString(1);
			 }
			result.close();
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userNo;
	}
	public List<String> manyByRole(String roleName){
		Connection conn=this.getConnection();
		List<String> users=new ArrayList<String>();
		String sql="SELECT uu.`no` from userinfo uu,roleinfo rr,userinfo_roleinfo ur where uu.id=ur.UserInfo_id and rr.id=ur.roles_id "
				+ "and rr.`name`='"+roleName+"'";
		try {
			Statement sta=conn.createStatement();
			ResultSet result=sta.executeQuery(sql);
			while  (result.next()){
				users.add(result.getString(1));
			}
			result.close();
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
}
