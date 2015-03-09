package com.gxuts.wss.dms.entity.hr;

import java.io.Serializable;

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
	
	 
	public StructureInfo() {}
	public StructureInfo(Integer id, String name, Integer pId) {
		this.id = id;
		this.name = name;
		this.pId = pId;
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
