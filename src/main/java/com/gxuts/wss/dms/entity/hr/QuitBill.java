package com.gxuts.wss.dms.entity.hr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
/**
 *离职申请 
 * @author nf0830
 */
@Entity
public class QuitBill implements Serializable{
	private String type;
	private String reason;
	@ManyToOne
	private UserInfo cadidate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lastWorkDate;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String no;
	private String name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	@ManyToOne
	private UserInfo createUser;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	private UserInfo updateUser;
	private String flowId;
	public QuitBill() {}
	public QuitBill(Integer id) {
		this.id=id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public UserInfo getCadidate() {
		return cadidate;
	}
	public void setCadidate(UserInfo cadidate) {
		this.cadidate = cadidate;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getLastWorkDate() {
		return lastWorkDate;
	}
	public void setLastWorkDate(Date lastWorkDate) {
		this.lastWorkDate = lastWorkDate;
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
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
}
