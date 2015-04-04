package com.gxuts.wss.dms.entity.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UrlInfo implements Serializable{
	private static final long serialVersionUID = 2599441712643704181L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String url;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate=new Date();
	
	public UrlInfo(){	}
	public UrlInfo(int id){
		this.id=id;
	}
	
	public UrlInfo(String url){
		this.url=url;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public boolean equals(Object obj) {
		return Pattern.compile(((UrlInfo)obj).getUrl()).matcher(this.url).find();
		//return  this.url.equals(((UrlInfo)obj).getUrl());
	}
	@Override
	public String toString() {
		return "[" + id + ":" + name + "]";
	}
	
	
	
	
}
