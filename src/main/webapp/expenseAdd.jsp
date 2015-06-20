<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style type="text/css" media="screen">
.my-uploadify-button {
	background:none;
	border: none;
	text-shadow: none;
	border-radius:0;
}

.uploadify:hover .my-uploadify-button {
	background:none;
	border: none;
}

.fileQueue {
	min-height: 58px;
	overflow: auto;
	border: 1px solid #E5E5E5;
	margin-bottom: 10px;
}
</style>
<div class="pageContent">
	<form id="detailForm" method="post" action="expense/save" 
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>基本信息</legend>
			<p>
				<label>单据编号：</label>
				<input name="no" type="text"   value="${no}" readonly="readonly" name="no" size="30"/>
			</p>
			<p>
				<label>提交人：</label>
				<input name="name" class="required" type="text" size="30" readonly="readonly" value="${loginUser.name}"/>
			</p>
			<p>
				<label>提交部门：</label>
				<input name="structureName" type="text" size="30" readonly="readonly" value="${loginUser.structure.name}"/>
			</p>
			<p>
			<label>付款方式：</label>
				<select name="type" class="required combox">
					<option value="">请选择</option>
					<option value="个人">现金付款</option>
					<option value="个人">支票付款</option>
					<option value="公司" selected>银行存款</option>
				</select>
			</p>
			<dl class="nowrap">
			<dt>附件：</dt>
			<dd>
				<input name="attachment.attachmentPath" value="" type="hidden">
				<input class="readonly" name="attachment.fileName" value="" readonly="readonly" type="text" size="30"/>
				<a class="btnAttach" href="depart/attachmentLookup.html" lookupGroup="attachment" width="560" height="300" title="附件">附件</a>
				<span class="info">(附件)</span>
			</dd>
		</dl>
			</fieldset>
			<fieldset>
				<legend>相关信息</legend>
			<p>
				<label>开发人员：</label>
				<input name="devUser"  type="text" size="30" value="${loginUser.name }"/>
			</p>
			<p>
				<label>开发部门：</label>
				<input name="devDepartment" value="${loginUser.name }"  type="text" size="30"/>
			</p>
			</fieldset>
			<fieldset>
				<legend>报销明细</legend>
			 	<div>
					<table class="list nowrap itemDetail" addButton="新建从表1条目" width="60%">
						<thead>
							<tr>
								<th type="del" width="28">删除</th>
								<th type="text" defaultVal="#index#" size="1" readonly="readonly" >序号</th>
								<th type="lookup" lookupGroup="items[#index#]" lookupUrl="subject/list?show=dialog"   name="items[#index#].name" size="12" fieldClass="required" size="12">费用科目</th>
								<th type="text" name="items[#index#].no" >科目编码</th>
								<th type="text" name="items[#index#].money" >金额</th>
								<th type="text" name="items[#index#].page"  size="12" fieldClass="digits">发票张数</th>
								<th type="text" name="items[#index#].structrue"  size="12" defaultVal="${loginUser.structure.id }" >部门</th>
							</tr>
						</thead>
						<tbody>	</tbody>
					</table>
				</div>
			</fieldset>
			 
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
				
	</form>
</div>
