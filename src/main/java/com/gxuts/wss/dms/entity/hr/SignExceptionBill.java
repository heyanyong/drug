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
 * 考勤异常单
 * @author nf0830
 *
 */
@Entity
public class SignExceptionBill implements Serializable{
	private int number;  //月次数
	private String type;
	private String reason;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date exceptionDate;
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
	public SignExceptionBill(Integer id) {
		this.id=id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getExceptionDate() {
		return exceptionDate;
	}
	public void setExceptionDate(Date exceptionDate) {
		this.exceptionDate = exceptionDate;
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
