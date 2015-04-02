package com.gxuts.wss.drug.base;

import java.lang.reflect.Field;

import org.junit.Test;

import com.gxuts.wss.dms.entity.finance.BudgetInfo;
import com.gxuts.wss.dms.util.annotation.FieldName;

public class TestAnnotation {
	@Test
	public void testGetFieldAnnot() throws NoSuchFieldException, SecurityException{
		BudgetInfo budget=new BudgetInfo();
		  Field oField = budget.getClass().getDeclaredField("january" );  
	        FieldName fn = oField  
	                .getAnnotation(FieldName.class );  
	        System.out.println( fn.name());  
	}
	
}
