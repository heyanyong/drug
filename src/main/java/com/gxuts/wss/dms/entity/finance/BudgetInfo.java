package com.gxuts.wss.dms.entity.finance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.util.annotation.FieldName;
@Entity
public class BudgetInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@FieldName(name="费用科目")
	private String name;
	@FieldName(name="费用科目编码")
	private String no;
	private int year;
	private boolean isAvailable;
	@ManyToOne
	private StructureInfo structure;
	@FieldName(name="一月")
	private double january ; 
	private double february ; 
	private double march ; 
	private double april ; 
	private double may ; 
	private double june ; 
	private double july ; 
	private double august ; 
	private double september  ; 
	private double october ; 
	private double november  ; 
	private double december  ; 
	
	@ManyToOne(fetch=FetchType.EAGER)
	private UserInfo createUser;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date updateTime;
	
	public BudgetInfo() {}
	public BudgetInfo(Integer id) {
		this.id=id;
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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public StructureInfo getStructure() {
		return structure;
	}
	public void setStructure(StructureInfo structure) {
		this.structure = structure;
	}
	public double getJanuary() {
		return january;
	}
	public void setJanuary(double january) {
		this.january = january;
	}
	public double getFebruary() {
		return february;
	}
	public void setFebruary(double february) {
		this.february = february;
	}
	public double getMarch() {
		return march;
	}
	public void setMarch(double march) {
		this.march = march;
	}
	public double getApril() {
		return april;
	}
	public void setApril(double april) {
		this.april = april;
	}
	public double getMay() {
		return may;
	}
	public void setMay(double may) {
		this.may = may;
	}
	public double getJune() {
		return june;
	}
	public void setJune(double june) {
		this.june = june;
	}
	public double getJuly() {
		return july;
	}
	public void setJuly(double july) {
		this.july = july;
	}
	public double getAugust() {
		return august;
	}
	public void setAugust(double august) {
		this.august = august;
	}
	public double getSeptember() {
		return september;
	}
	public void setSeptember(double september) {
		this.september = september;
	}
	public double getOctober() {
		return october;
	}
	public void setOctober(double october) {
		this.october = october;
	}
	public double getNovember() {
		return november;
	}
	public void setNovember(double november) {
		this.november = november;
	}
	public double getDecember() {
		return december;
	}
	public void setDecember(double december) {
		this.december = december;
	}
	public UserInfo getCreateUser() {
		return createUser;
	}
	public void setCreateUser(UserInfo createUser) {
		this.createUser = createUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
