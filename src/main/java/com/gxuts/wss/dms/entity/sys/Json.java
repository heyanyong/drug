package com.gxuts.wss.dms.entity.sys;

public class Json {
	private String message="操作成功";
	private String statusCode="200";
	private String navTabId;
	private String rel;
	private String callbackType;
	private String forwardUrl;
	
	public Json(){}
	
	public Json(String message, String statusCode, String navTabId, String rel,
			String callbackType, String forwardUrl) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.navTabId = navTabId;
		this.rel = rel;
		this.callbackType = callbackType;
		this.forwardUrl = forwardUrl;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	@Override
	public String toString() {
		return "Json [message=" + message + ", statusCode=" + statusCode
				+ ", navTabId=" + navTabId + ", rel=" + rel + ", callbackType="
				+ callbackType + ", forwardUrl=" + forwardUrl + "]";
	}
	
	
}
