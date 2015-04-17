package com.gxuts.wss.drug.base;

import com.gxuts.wss.dms.util.annotation.FieldName;

public class Car {
	@FieldName(name="标识")
	int id=1;
	@FieldName(name="名称")
	String name;
	int price;
	
	
	public Car() {}


	public Car(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
