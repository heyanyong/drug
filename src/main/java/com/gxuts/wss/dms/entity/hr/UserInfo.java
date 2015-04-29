package com.gxuts.wss.dms.entity.hr;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import liquibase.util.MD5Util;

@Entity
public class UserInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique=true)  //无效
	private String no;
//	@Column(nullable=false)
	private String name;
	private int age;
	private String password;
	private String sex;
	private String phone;
	private String email;
	private String remark;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entryDate;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date updateTime;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	@ManyToOne(fetch=FetchType.EAGER)
	private UserInfo createUser;
	@ManyToOne(fetch=FetchType.EAGER)
	private UserInfo updateUser;
	@ManyToOne
	private StructureInfo structure;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<RoleInfo> roles;

	public UserInfo(){}
	public UserInfo(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public String getRemark() {
		return remark;
	}
	

	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public UserInfo getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(UserInfo updateUser) {
		this.updateUser = updateUser;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public StructureInfo getStructure() {
		return structure;
	}
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStructure(StructureInfo structure) {
		this.structure = structure;
	}

	public List<RoleInfo> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleInfo> roles) {
		this.roles = roles;
	}
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", no=" + no + ", name=" + name + "]";
	}
	@Override
	public boolean equals(Object obj) {
		UserInfo u=(UserInfo)obj;
		return this.id==u.getId();
	}
	@Override
	public int hashCode() {
		return this.id.hashCode()*7;
	}
	

	 
	 

}
