package com.gxuts.wss.dms.entity.sys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.gxuts.wss.dms.entity.hr.UserInfo;
/**
 * 表单附件类
 * @author nf0830
 */
@Entity
public class AttaFile  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private boolean isOk;
	private String webPath;
	private String fileName;
	private String fileType;
	@ManyToOne(fetch=FetchType.LAZY)
	private UserInfo createUser;
	
	
	
	public UserInfo getCreateUser() {
		return createUser;
	}
	public void setCreateUser(UserInfo createUser) {
		this.createUser = createUser;
	}
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public String getWebPath() {
		return webPath;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	@Override
	public String toString() {
		return this.fileName;
	}
	
}
