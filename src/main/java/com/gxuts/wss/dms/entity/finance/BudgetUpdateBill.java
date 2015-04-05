package com.gxuts.wss.dms.entity.finance;
import java.util.Date;
import java.util.List;
public class BudgetUpdateBill {
	private Date createDate;
	private List<BudgetInfo> budgets;
	private Integer structrueId;
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
	public Integer getStructrueId() {
		return structrueId;
	}
	public void setStructrueId(Integer structrueId) {
		this.structrueId = structrueId;
	}
	@Override
	public String toString() {
		return "BudgetUpdateBill [createDate=" + createDate + ", budgets="
				+ budgets + ", structrueId=" + structrueId + "]";
	}
	
	
}
