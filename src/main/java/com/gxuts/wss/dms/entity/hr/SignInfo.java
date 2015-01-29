package com.gxuts.wss.dms.entity.hr;

import java.util.Date;

public class SignInfo {
	private String no;
	private String name;
	private String department;
	private Date recordDate;
	private String status;
	private Date signIn;
	private Date signOut;
	private Integer lateMinute;
	private String remark;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
