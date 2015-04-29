package com.gxuts.wss.dms.entity.finance;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.gxuts.wss.dms.entity.hr.StructureInfo;
import com.gxuts.wss.dms.util.annotation.FieldName;

@Entity
public class ExpenseItem  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@FieldName(name="费用科目编码")
	private String no;
	@FieldName(name="费用科目名称")
	private String name;
	private int page;
	private double money;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	
	@ManyToOne
	private StructureInfo structure;
	@ManyToOne
	private ExpenseBill expense;
	
	public ExpenseBill getExpense() {
		return expense;
	}
	
	public StructureInfo getStructure() {
		return structure;
	}

	public void setStructure(StructureInfo structure) {
		this.structure = structure;
	}

	public void setExpense(ExpenseBill expense) {
		this.expense = expense;
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "ExpenseItem [name=" + name + ", money=" + money + ", expense="
				+ expense + "]";
	}
	
}
