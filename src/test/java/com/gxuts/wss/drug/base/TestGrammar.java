package com.gxuts.wss.drug.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestGrammar {
	
	public void say(String name, int...arry){
		System.out.println(name);
		System.out.println(arry[2]);
	}
	
	
	@Test
	public void  testMtilParameter(){
		say("pp",1,1,3);
	}
	@Test
	public void testDateChange(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		String aa=df.format(new Date());
		System.out.println(aa);
	}

}
