package com.gxuts.wss.dms.entity.business;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




import javax.persistence.OneToMany;

import com.gxuts.wss.dms.entity.hr.UserInfo;
@Entity
public class ExportDrug implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	
	private Integer drugId;
	private Integer exportNum;
	@ManyToOne
	private ExportBill exportBill;
	
	
	public ExportDrug(){};

	public ExportDrug(Integer id) {
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

	public ExportBill getExportBill() {
		return exportBill;
	}

	public void setExportBill(ExportBill exportBill) {
		this.exportBill = exportBill;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UserInfo getCreateUser() {
		return createUser;
	}

	public void setCreateUser(UserInfo createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public UserInfo getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UserInfo updateUser) {
		this.updateUser = updateUser;
	}

	public Integer getDrugId() {
		return drugId;
	}

	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}

	public Integer getExportNum() {
		return exportNum;
	}

	public void setExportNum(Integer exportNum) {
		this.exportNum = exportNum;
	}

	@Override
	public String toString() {
		return "ExportDrug [id=" + id + ", name=" + name + ", drugId=" + drugId
				+ ", exportNum=" + exportNum + "]";
	}
	
	 
	 
}
