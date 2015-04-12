package com.gxuts.wss.dms.entity.finance;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.gxuts.wss.dms.entity.hr.StructureInfo;
@Entity
public class BudgetBill implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String no;
	private String name;
	private Date createDate;
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)  
	private List<BudgetInfo> budgets;
	@OneToOne
	private StructureInfo structure;
	 
	
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


	public List<BudgetInfo> getBudgets() {
		return budgets;
	}


	public void setBudgets(List<BudgetInfo> budgets) {
		this.budgets = budgets;
	}



	public StructureInfo getStructure() {
		return structure;
	}


	public void setStructure(StructureInfo structure) {
		this.structure = structure;
	}


	@Override
	public String toString() {
		return "BudgetUpdateBill [createDate=" + createDate + ", budgets="
				+ budgets + ", structrueId=" + structure + "]";
	}
	
	
}
