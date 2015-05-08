<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pageContent">
	<form id="detailForm" method="post" action="pay/save" class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><a class="buttonActive" href="javascript:saveBill('detailForm');"><span>保存</span></a></li>
			</ul>
		</div>
		<div class="pageFormContent payBill" layoutH="56">
			<p>
				<input name="createUser.id" type="hidden" value="${loginUser.id}"
					size="30" /> <label>编号：</label> <input name="no" type="text"
					readonly="readonly" value="${no}" size="30" />
			</p>
			<p>
				<label>申请人：</label> <input value="${loginUser.name}"
					readonly="readonly" type="text" size="30" />
			</p>
			<p>
				<label>申请工号：</label> <input value="${loginUser.no}"
					readonly="readonly" type="text" size="30" />
			</p>
			<p>
				<label>部门：</label> <input type="text" size="30" readonly="readonly"
					value="${loginUser.structure.name}" />
			</p>
			<p>
				<label>所属客户：</label> <input type="hidden" name="customer.id" /> <input
					type="text" class="required" name="customer.name" size="30" readonly="readonly" /> 
					<a class="btnLook" href="customer/list?show=dialog" lookupGroup="customer" width="500">查找带回</a>
			</p>
			<p>
				<label>供应商：</label> <input type="hidden" name="supplier.id" /> <input
					type="text" class="required" name="supplier.name" size="30" readonly="readonly" />
					<a class="btnLook" href="supplier/list?show=dialog" lookupGroup="supplier" width="500">查找带回</a>
			</p>
			<p>
				<label>业务类型：</label> <select name="type">
					<option value="">请选择</option>
					<option value="代理">代理</option>
					<option value="采购">采购</option>
				</select>
			</p>
			<p>
				<label>风险类型：</label> <select name="riskType">
					<option value="">请选择</option>
					<option value="高风险">高风险</option>
					<option value="低风险">低风险</option>
				</select>
			</p>
			<p>
				<label>付款方式：</label> <select name="payType">
					<option value="">请选择</option>
					<option value="高风险">高风险</option>
					<option value="低风险">低风险</option>
				</select>
			</p>

			<p>
				<label>外汇牌价时间：</label> <input type="text" name="exchangeTime" class="date required" size="30" dateFmt="yyyy-MM-dd HH:mm:ss" />
				<a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>总共已收：</label> <input type="text" size="30" name="number" />
			</p>
			<p>
				<label>总共应收：</label> <input type="text" size="30" name="number" />
			</p>
			<p>
				<label>超期应收：</label> <input type="text" size="30" name="number" />
			</p>
			<p>
				<label>这笔后应收：</label> <input type="text" size="30" name="number" />
			</p>
			<p>
				<label>付款总计：</label> <input type="text" size="30" name="number" />
			</p>
			<p>
				<label>付款总计大写：</label> <input type="text" size="30" name="number" />
			</p>
			<p>
				<label>币种：</label> <select name="type" class="combox">
					<option value="">请选择</option>
					<option value="RMB">RMB</option>
					<option value="USD">USD</option>
				</select>
			</p>
			<dl class="nowrap">
				<dd>
					<fieldset>
						<legend>款项信息</legend>
						<table class="list nowrap itemDetail" addButton="追加明细项" width="100%">
							<thead>
								<tr>
									<th type="del" width="28">删除</th>
									<th type="text" name="items[#index#].used" size="12">用途</th>
									<th type="text" name="items[#index#].income" size="6" fieldClass="digits">已收</th>
									<th type="text" name="items[#index#].recome" size="6" fieldClass="digits">应收</th>
									<th type="text" name="items[#index#].computed" size="6" fieldClass="digits">折算</th>
									<th type="text" name="items[#index#].payment" size="6" fieldClass="digits">付款总记</th>
									<th type="text" name="items[#index#].payment" size="6" fieldClass="digits">已收币种</th>
									<th type="enum" name="items[#index#].payCurrency" enumUrl="demo/database/db_select.html" size="6">应收币种</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</fieldset>
				</dd>
			</dl>
			<dl class="nowrap">
			  <dd>
				<fieldset>
					<legend>分批付款情况</legend>
					<table class="list nowrap itemDetail" addButton="追加明细项"
						width="100%">
						<thead>
							<tr>
								<th type="del" width="28">删除</th>
								<th type="text" defaultVal="#index#" size="1">序号</th>
								<th type="text" name="items[#index#].name" size="52">名称</th>
								<th type="text" name="items[#index#].voteNum" size="6" fieldClass="digits">初始票数</th>
							</tr>
						</thead>
						<tbody> </tbody>
					</table>
				 </fieldset>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd>
					<textarea name="remark" cols="95" rows="3"></textarea>
				</dd>
			</dl>
		</div>
	</form>
</div>
<script>
	function saveBill(form) {
		$("#" + form).attr("action", "pay/save");
		$("#" + form).submit();
	}
	function dealBill(form) {
		$("#" + form).attr("action", "pay/deal");
		$("#" + form).submit();
	}
</script>