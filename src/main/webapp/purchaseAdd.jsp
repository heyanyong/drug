<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="get" action="purchase/save"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>编号：</label> <input name="no" type="text" size="30" readonly="readonly" value="${no}"/>
			</p>
			<p>
				<label>提交人：</label> <input    type="text" 
					size="30"    readonly="readonly"  value="${loginUser.name}"/>
			</p>
			<p>
				<label>提交工号：</label> <input   type="text" 
					size="30"    readonly="readonly"  value="${loginUser.no}"/>
			</p>
			<p>
				<label>提交部门：</label> <input name="name"   type="text" 
					size="30"   readonly="readonly"  value="${loginUser.name}" />
			</p>
			<p>
				<label>采购主体：</label> <input name="name" class="required" type="text" 
					size="30" value="XX科技有限公司" />
			</p>
			<p>
				<label>部门编号：</label> <input type="text" readonly="readonly" value=""
					name="dwz_orgLookup.orgNum" class="textInput">
			</p>
			<p>
				<label>总预算：</label> <input name="budget" class="number" type="text"
					size="30" alt="请输入数字" />
			</p>
			<p>
				<label>需求类型：</label> <select name="type" class="required combox">
					<option value="">请选择</option>
					<option value="补仓" selected>补仓</option>
					<option value="新增" selected>新增</option>
					<option value="混合" selected>混合</option>
				</select>
			</p>
			<p>
				<label>完成日期：</label> <input type="text" name="completeDate"
					class="date" size="30" /><a class="inputDateButton"
					href="javascript:;">选择</a>
			</p>
			<p>
				<label>采购方式：</label> <select name="capital"   name="purchaseWay"  class="required combox">
					<option value="">请选择</option>
					<option value="招标采购"> 招标采购 </option>
					<option value="非招标采购" selected> 非招标采购 </option>
				</select> 
			</p>
			<dl class="nowrap">
			<dt>附件：</dt>
			<dd>
				<input name="attachment.id" value="" type="hidden">
				<input class="readonly" name="attachment.fileName" value="" readonly="readonly" type="text"/>
				<a class="btnAttach" href="demo/database/db_attachmentLookup.html" lookupGroup="attachment" width="560" height="300" title="附件">附件</a>
				<span class="info">(点击上传文件)</span>
			</dd>
		</dl>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd>
					<textarea name="remark" cols="95" rows="2"></textarea>
				</dd>
			</dl>
			<div class="divider"></div>
			<div class="panel collapse" minH="180" width=61% style="width:63%;">
				<h1>药品明细 </h1>
				<div>
					<table class="list nowrap itemDetail" addButton="新建从表1条目" width="100%">
						<thead>
							<tr>
								<th type="del" width="28">删除</th>
								<th type="text" defaultVal="#index#" size="12"  >序号</th>
								<th type="text" name="drugs[#index#].name" >名称</th>
								<th type="text" name="drugs[#index#].requestNumber"  size="12" fieldClass="digits">需求数量</th>
							</tr>
						</thead>
						<tbody>	</tbody>
					</table>
				</div>
			</div>

		</div>

	</form>
</div>
<script src="js/my.extend.js" type="text/javascript"></script>
