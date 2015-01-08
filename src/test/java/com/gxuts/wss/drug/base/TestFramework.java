package com.gxuts.wss.drug.base;


import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFramework {
	public ApplicationContext getContext(){
		ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		return context;
	}
	 public static void main( String[] args )
	    {
	    	ApplicationContext context=new TestFramework().getContext();
	    	SessionFactory sf=(SessionFactory) context.getBean("sessionFactory");
	    	System.out.println(sf);
	    }
}
