package com.gxuts.wss.dms.entity.manage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.gxuts.wss.dms.entity.hr.UserInfo;

@Entity
public class VoteInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String no;
	private String content;
	private Boolean isOpen;
	private Boolean isShowVoter;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<VoteItem> items;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo createUser;

	public Integer getId() {
		return id;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Boolean getIsShowVoter() {
		return isShowVoter;
	}

	public void setIsShowVoter(Boolean isShowVoter) {
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
	public int getTotalVote(){
		int total=0;
		for(VoteItem i:items){
			total+=i.getVoteNum();
		}
		return total;
	}
	
	public String getUsersVoted(){
		StringBuilder usersVoted=new StringBuilder();
		for(VoteItem it:items){
			String ud=it.getUsers();
			if(ud!=null){
				usersVoted.append(ud);
			}
		}
		return usersVoted.toString();
	}
	@Override
	public String toString() {
		return "VoteInfo [name=" + name + ", items=" + items + "]";
	}

}
