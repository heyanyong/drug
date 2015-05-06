package com.gxuts.wss.dms.entity.csrm;

import java.io.Serializable;
import java.util.Date;

import com.gxuts.wss.dms.entity.hr.UserInfo;

public class ContactInfo implements Serializable{
	private Integer id;
	private String name;
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	
	private String phone;
	private String address;
	private String email;
	private String qq;
	private String postcode;
	
	
}
