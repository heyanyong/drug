package com.gxuts.wss.drug.entity.business;

import java.io.Serializable;
import java.util.Date;

import com.gxuts.wss.drug.entity.hr.UserInfo;

public class ExportBill implements Serializable{
	private Integer id;
	private String name;
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
}
