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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gxuts.wss.dms.entity.hr.UserInfo;
@Entity
public class DrugInfo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String no;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	
	@Temporal(TemporalType.DATE)
	private Date productDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private Integer alertDay;
	private Integer alertNumber;
	private Integer requestNumber;
	private Integer purchaseNumber;
	private String unit;
	@ManyToOne
	private PurchaseContractBill contract;
	
	public DrugInfo(){};

	public DrugInfo(Integer id) {
		this.id=id;
	}
	
	
	public Date getEndDate() {
		return endDate;
	}

	public Integer getAlertNumber() {
		return alertNumber;
	}

	public void setAlertNumber(Integer alertNumber) {
		this.alertNumber = alertNumber;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Integer getAlertDay() {
		return alertDay;
	}

	public void setAlertDay(Integer alertDay) {
		this.alertDay = alertDay;
	}

	public PurchaseContractBill getContract() {
		return contract;
	}

	public void setContract(PurchaseContractBill contract) {
		this.contract = contract;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "DrugInfo [id=" + id + ", name=" + name + ", no=" + no
				+ ", contract=" + contract + "]";
	}

	
	 
}
