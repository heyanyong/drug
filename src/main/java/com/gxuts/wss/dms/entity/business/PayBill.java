package com.gxuts.wss.dms.entity.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gxuts.wss.dms.entity.csrm.CustomerInfo;
import com.gxuts.wss.dms.entity.csrm.SupplierInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.AttaFile;
/**
 * 付款申请单
 * @author nf0830
 *
 */
@Entity
public class PayBill implements Serializable{
	
	private String type;     			//业务类型
	private String currency; 			//币种
	private Double incTotal; 			//已收
	private Double recTotal; 			//应收
	private Double recExpire; 			//超期应收
	private Double recRemain; 			//这笔后应收
	private Double payTotal;  			//付款总计
	private String payTotalCH; 			//总计大写
	private String riskType;  			//风险类型
	private String payType;  			//付款方式
	private CustomerInfo customer;  	//客户
	private SupplierInfo supplier;  	//供应商
	private Date  exchangeTime;  		//外汇牌价时间
	private String remark;
	private List<AttaFile> files;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String no;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	@ManyToOne
	private UserInfo createUser;
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	@ManyToOne
	private UserInfo updateUser;

	public PayBill(Integer id) {
		this.id = id;
	}
	public PayBill() {
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getIncTotal() {
		return incTotal;
	}
	public void setIncTotal(Double incTotal) {
		this.incTotal = incTotal;
	}
	public Double getRecTotal() {
		return recTotal;
	}
	public void setRecTotal(Double recTotal) {
		this.recTotal = recTotal;
	}
	public Double getRecExpire() {
		return recExpire;
	}
	public void setRecExpire(Double recExpire) {
		this.recExpire = recExpire;
	}
	public Double getRecRemain() {
		return recRemain;
	}
	public void setRecRemain(Double recRemain) {
		this.recRemain = recRemain;
	}
	public Double getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(Double payTotal) {
		this.payTotal = payTotal;
	}
	public String getPayTotalCH() {
		return payTotalCH;
	}
	public void setPayTotalCH(String payTotalCH) {
		this.payTotalCH = payTotalCH;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public CustomerInfo getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}
	public SupplierInfo getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierInfo supplier) {
		this.supplier = supplier;
	}
	public Date getExchangeTime() {
		return exchangeTime;
	}
	public void setExchangeTime(Date exchangeTime) {
		this.exchangeTime = exchangeTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public UserInfo getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(UserInfo updateUser) {
		this.updateUser = updateUser;
	}
	
	 
	
}
