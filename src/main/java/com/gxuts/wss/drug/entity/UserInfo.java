package com.gxuts.wss.drug.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import liquibase.util.MD5Util;

@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique=true)  //无效
	private String no;
	@Column(nullable=false)
	private String name;
	private int age;
	private String password;
	private String sex;
	private Date createDate;
	@ManyToOne(fetch=FetchType.EAGER)
	private UserInfo createUser;
	@ManyToOne
	private StructureInfo structure;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<RoleInfo> roles;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public StructureInfo getStructure() {
		return structure;
	}

	public void setStructure(StructureInfo structure) {
		this.structure = structure;
	}

	public Set<RoleInfo> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleInfo> roles) {
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
		this.password = MD5Util.computeMD5(password);
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", no=" + no + ", name=" + name
				+ ", age=" + age + ", password=" + password + ", sex=" + sex
				+ ", createDate=" + createDate + ", createUser=" + createUser
				+ ", structure=" + structure + ", roles=" + roles + "]";
	}

	 
	 

}
