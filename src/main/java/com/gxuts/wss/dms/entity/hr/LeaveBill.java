package com.gxuts.wss.dms.entity.hr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gxuts.wss.dms.entity.hr.UserInfo;
@Entity
public class LeaveBill implements Serializable{
	private Date startDate;
	private Date endDate;
	private UserInfo cadidate;
	private String reason;
	private String status;
	private String type;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private Date createDate;
	private UserInfo createUser;
	private Date updateDate;
	private UserInfo updateUser;
	private int isEnd;
	
	public Date getStartDate() {
		return startDate;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public UserInfo getCadidate() {
		return cadidate;
	}
	public void setCadidate(UserInfo cadidate) {
		this.cadidate = cadidate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
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
	
}
