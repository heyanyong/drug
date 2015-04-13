package com.gxuts.wss.dms.entity.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gxuts.wss.dms.entity.hr.UserInfo;
@Entity
public class CustomerInfo implements Serializable{
	
	private String simpleName;
	private String englishName;
	private String type;
	private String contactPerson;
	private String phone;
	private String address;
	private String certificationNo;
	private String foundDate;
	private String industry;
	private String legalPerson;
	private String mainBusiness;
	private String remark;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String no;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@ManyToOne
	private UserInfo createUser;
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	@ManyToOne
	private UserInfo updateUser;

	public CustomerInfo(Integer id) {
		this.id = id;
	}
	public CustomerInfo() {
	}
	
	
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCertificationNo() {
		return certificationNo;
	}
	public void setCertificationNo(String certificationNo) {
		this.certificationNo = certificationNo;
	}
	public String getFoundDate() {
		return foundDate;
	}
	public void setFoundDate(String foundDate) {
		this.foundDate = foundDate;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getMainBusiness() {
		return mainBusiness;
	}
	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	@Override
	public String toString() {
		return "CustomerInfo [id=" + id + ", no="
				+ no + ", name=" + name + "]";
	}
	
}
