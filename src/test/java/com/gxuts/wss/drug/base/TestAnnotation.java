package com.gxuts.wss.drug.base;

import java.lang.reflect.Field;

import org.junit.Test;

import com.gxuts.wss.dms.entity.finance.BudgetInfo;
import com.gxuts.wss.dms.util.annotation.FieldName;

public class TestAnnotation {
	@Test
	public void testGetFieldAnnot() throws NoSuchFieldException{
		BudgetInfo budget=new BudgetInfo();
		  Field oField = budget.getClass().getDeclaredField("january" );  
	        FieldName fn = oField  
	                .getAnnotation(FieldName.class );  
	        System.out.println( fn.name());  
	}
	//获取字段名和中文名
	@Test
	public void getGetAllField() throws NoSuchFieldException{
		Car car=new Car(2,"qq",300);
		Field[] fields=car.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			  FieldName cnName = fields[i].getAnnotation(FieldName.class);
			  if(cnName!=null){
				  String name = fields[i].getName();
				  System.out.println(cnName.name()+name); 
			  }
		}
		
		
	}
}
