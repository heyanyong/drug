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
public class DrugInfo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	
	private Integer requestNumber;
	private Integer purchaseNumber;
	private Integer exportNumber;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PurchaseContractBill contract;
	
	public DrugInfo(){};

	public DrugInfo(Integer id) {
		this.id=id;
	}
	
	public PurchaseContractBill getContract() {
		return contract;
	}

	public void setContract(PurchaseContractBill contract) {
		this.contract = contract;
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
	
	public Integer getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}
	public Integer getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(Integer purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	public Integer getExportNumber() {
		return exportNumber;
	}
	public void setExportNumber(Integer exportNumber) {
		this.exportNumber = exportNumber;
	}
	
 

	@Override
	public String toString() {
		return "DrugInfo [id=" + id + ", name=" + name + "]";
	}
	
	 
}
