package com.gxuts.wss.dms.entity.manage;

import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.gxuts.wss.dms.entity.hr.UserInfo;

public class VoteInfo {
	private Integer id;
	private String name;
	private String content;
	private boolean isShowVoter;
	@OneToMany(fetch=FetchType.LAZY)
	private List<VoteItem> items;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	@ManyToOne(fetch=FetchType.LAZY)
	private UserInfo createUser;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isShowVoter() {
		return isShowVoter;
	}
	public void setShowVoter(boolean isShowVoter) {
		this.isShowVoter = isShowVoter;
	}
	public List<VoteItem> getItems() {
		return items;
	}
	public void setItems(List<VoteItem> items) {
		this.items = items;
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
	@Override
	public String toString() {
		return "VoteInfo [name=" + name + ", items=" + items + "]";
	}
	
	
}

