package com.gxuts.wss.dms.entity.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	private String remark;
	private Date completeDatel;
	private String type;

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
