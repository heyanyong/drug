package com.gxuts.wss.dms.entity.hr;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class SignInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String userNo;
	private String userName;
	private String departmentName;
	private Date recordDate;
	private String status;
	private Date signIn;
	private Date signOut;
	private Integer lateMinute;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	 
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSignIn() {
		return signIn;
	}
	public void setSignIn(Date signIn) {
		this.signIn = signIn;
	}
	public Date getSignOut() {
		return signOut;
	}
	public void setSignOut(Date signOut) {
		this.signOut = signOut;
	}
	public Integer getLateMinute() {
		return lateMinute;
	}
	public void setLateMinute(Integer lateMinute) {
		this.lateMinute = lateMinute;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	 
	
}
