package com.gxuts.wss.dms.entity.sys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuInfo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer pId;
	private Boolean isParent;
	private String icon;
	private boolean open;
	private String urlStr;
	 
	public MenuInfo() {}
	public MenuInfo(Integer id, String name, Integer pId) {
		this.id = id;
		this.name = name;
		this.pId = pId;
	}
	
	public String getUrlStr() {
		return urlStr;
	}
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
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
	@Override
	public String toString() {
		return "MenuInfo [id=" + id + ", name=" + name + ", pId=" + pId
				+ ", isParent=" + isParent + ", open=" + open + ", urlStr="
				+ urlStr + "]";
	}
	 
}
