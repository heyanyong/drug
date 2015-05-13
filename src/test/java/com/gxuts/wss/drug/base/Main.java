package com.gxuts.wss.drug.base;

import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		StringBuilder bk=new StringBuilder();
		String dept="";
		String userName="";
		String userNo="";
		String title="请假";
		if(dept!=null&&!"".equals(dept)){
			bk.append(dept+"#");
		}
		if(userName!=null&&!"".equals(userName)){
			bk.append(userName);
		}else{
			bk.append("%");
		}
		if(userNo!=null&&!"".equals(userNo)){
			bk.append("("+userNo+")#");
		}else{
			bk.append("%");
		}
		if(title!=null&&!"".equals(title)){
			bk.append(title+"#");
		}
		
		System.out.println(bk.toString());
	}
}
