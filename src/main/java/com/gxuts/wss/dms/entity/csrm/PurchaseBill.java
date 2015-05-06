package com.gxuts.wss.dms.entity.csrm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import com.gxuts.wss.dms.entity.hr.UserInfo;
 

@Entity
public class PurchaseBill implements Serializable {
	private static final long serialVersionUID = 3346828780680648200L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String no;
	private String name;
	private Date createDate;
	@ManyToOne
	private UserInfo createUser;
	private Date updateDate;
	@ManyToOne
	private UserInfo updateUser;
	
	private String remark;
	private double budget;
	private Date completeDatel;
	private String type;
	private String purchaseWay;

	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)  
	private List<DrugInfo> drugs;

	public PurchaseBill(){};
	public PurchaseBill(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public String getNo() {
		return no;
	}

	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getPurchaseWay() {
		return purchaseWay;
	}
	public void setPurchaseWay(String purchaseWay) {
		this.purchaseWay = purchaseWay;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setNo(String no) {
		this.no = no;
	}

	public Date getCompleteDatel() {
		return completeDatel;
	}

	public void setCompleteDatel(Date completeDatel) {
		this.completeDatel = completeDatel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public List<DrugInfo> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<DrugInfo> drugs) {
		this.drugs = drugs;
	}

	@Override
	public String toString() {
		return "PurchaseBill [id=" + id + ", name=" + name + ", drugs=" + drugs
				+ "]";
	}

}
