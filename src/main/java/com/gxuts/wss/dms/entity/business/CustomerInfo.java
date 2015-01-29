package com.gxuts.wss.dms.entity.business;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.gxuts.wss.dms.entity.hr.UserInfo;

public class CustomerInfo implements Serializable{
	private Integer id;
	private String name;
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	
	private Set<ContactInfo> contacts;
	
	
	
}
