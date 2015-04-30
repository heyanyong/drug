package com.gxuts.wss.dms.entity.manage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;

@Entity
public class AssetInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String no;
	private String name;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	@ManyToOne(fetch=FetchType.EAGER)
	private UserInfo createUser;
	@ManyToOne(fetch=FetchType.EAGER)
	private UserInfo updateUser;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date updateTime;
 }
