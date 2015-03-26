package com.gxuts.wss.dms.entity.finance;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.AttaFile;
@Entity
public class ExpenseBill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String no;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	private UserInfo createUser;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	@OneToMany(cascade=CascadeType.ALL)
	private List<AttaFile> files;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="expense",fetch=FetchType.EAGER)
	private List<ExpenseItem> items;
	
	
	
	public ExpenseBill(Integer id) {
		this.id = id;
	}
	public ExpenseBill() {
	}
	public List<ExpenseItem> getItems() {
		return items;
	}
	public void setItems(List<ExpenseItem> items) {
		this.items = items;
	}
	public List<AttaFile> getFiles() {
		return files;
	}
	public void setFiles(List<AttaFile> files) {
		this.files = files;
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
	@Override
	public String toString() {
		return "ExpenseBill [id=" + id + ", no=" + no + ", createDate="
				+ createDate + ", createUser=" + createUser + ", files="
				+ files + "]";
	}
	 
	
	
	
}
