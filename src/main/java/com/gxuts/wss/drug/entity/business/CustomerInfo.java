package com.gxuts.wss.drug.entity.business;

import java.util.Date;
import java.util.Set;

import com.gxuts.wss.drug.entity.hr.UserInfo;

public class CustomerInfo {
	private Integer id;
	private String name;
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	
	private Set<ContactInfo> contacts;
	
	
	
}
