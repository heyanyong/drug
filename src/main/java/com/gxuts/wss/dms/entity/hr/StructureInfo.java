package com.gxuts.wss.dms.entity.hr;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StructureInfo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer pId;
	private Boolean isParent;
	private String icon="images/diy/department.png";
	private boolean open=true;
//	private List<String> fileName;
	
	 
	public StructureInfo() {}
	public StructureInfo(Integer id, String name, Integer pId,Boolean isParent) {
		this.id = id;
		this.name = name;
		this.pId = pId;
		this.isParent=isParent;
	}
	
//	public List<String> getFileName() {
//		return fileName;
//	}
//	public void setFileName(List<String> fileName) {
//		this.fileName = fileName;
//	}
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
		return "StructureInfo [id=" + id + ", name=" + name + ", Pid=" + pId
				+ "]";
	}
	 
}
