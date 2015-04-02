package com.gxuts.wss.dms.entity.hr;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.gxuts.wss.dms.entity.sys.UrlInfo;

@Entity
public class RoleInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private int grade;
	private Date createDate;
	@ManyToMany
	private List<UrlInfo> urls;
	
	
	
	public List<UrlInfo> getUrls() {
		return urls;
	}
	public void setUrls(List<UrlInfo> urls) {
		this.urls = urls;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public RoleInfo(){}
	public RoleInfo(Integer id){
		this.id=id;
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
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
}
