<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
  .editTable{border:1px solid #ccc;}
  .editTable th{text-align: center;}
</style>

<div class="pageContent">
	<form method="get" action="purchase/save"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
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
				<label>编号：</label> <input name="no" type="text" size="30" value="${purchase.no}"/>
			</p>
			<p>
				<label>客户名称：</label> <input name="name" class="required" type="text" 
					size="30"   alt="请输入客户名称" />
			</p>
			<p>
				<label>部门名称：</label> <input type="hidden" name="orgLookup.id"
					value="${orgLookup.id}" /> <input type="text" class="required"
					name="orgLookup.orgName" value="" suggestFields="orgNum,orgName"
					suggestUrl="demo/database/db_lookupSuggest.html"
					lookupGroup="orgLookup" /> <a class="btnLook"
					href="demo/database/dwzOrgLookup.html" lookupGroup="orgLookup">查找带回</a>
			</p>
			<p>
				<label>部门编号：</label> <input type="text" readonly="readonly" value=""
					name="dwz_orgLookup.orgNum" class="textInput">
			</p>
			<p>
				<label>识 别 码：</label> <input name="code" class="digits" type="text"
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
				<label>营业执照号：</label> <input type="text" size="30" />
			</p>
			<p>
				<label>完成日期：</label> <input type="text" name="completeDate"
					class="date" size="30" /><a class="inputDateButton"
					href="javascript:;">选择</a>
			</p>
			<p>
				<label>创建日期：</label> <input type="text" name="endDate"
					class="date" size="30" /><a class="inputDateButton"
					href="javascript:;">选择</a>
			</p>
			<p>
				<label>修改日期：</label> <input type="text" name="endDate"
					class="date" size="30" /><a class="inputDateButton"
					href="javascript:;">选择</a>
			</p>
			<p>
				<label>注册资金：</label> <select name="capital" class="required combox">
					<option value="">请选择</option>
					<option value="10">10</option>
					<option value="50" selected>50</option>
					<option value="100">100</option>
				</select> <span class="unit">万元</span>
			</p>
			<p>
				<label>注册类型：</label> <input type="text" size="30" />
			</p>
			<dl class="nowrap">
				<dt>普通文本框：</dt>
				<dd>
					<textarea name="textarea1" cols="88" rows="2"></textarea>
				</dd>
			</dl>
			<div class="divider"></div>
			<div class="panel collapse" minH="100" >
				<h1>药品明细 <span class="addRowt"   onclick="addRow('editTable1');">添加行<b>+</b></span><span class="delRowt" onclick="removeRow('editTable1');">删除行-</span></h1>
				<div>
					<table class="editTable" id="editTable1">
							<thead>
								<tr>
									<th>&nbsp;</th>
									<th>编号</th>
									<th>名称</th>
									<th>需求数量</th>
									<th>日期</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" name="rowHead" /></td>
									<td><input type="text" name="drugs[0].name" value="${e.name}" /></td>
									<td><input type="hidden" name="orgLookup.id"
										value="${orgLookup.id}" /> <input type="text"
										class="required" name="orgLookup.orgName" value=""
										suggestFields="orgNum,orgName"
										suggestUrl="demo/database/db_lookupSuggest.html"
										lookupGroup="orgLookup" /> <a class="btnLook"
										href="demo/database/dwzOrgLookup.html" lookupGroup="orgLookup">查找带回</a></td>
									<td><input type="text" name="drugs[0].no" /></td>
									<td><input type="text" name="completeDate"
					class="date" size="30" /><a class="inputDateButton"
					href="javascript:;">选择</a></td>
								</tr>

							</tbody>
						</table>
				
				</div>
			</div>

		</div>

	</form>
</div>
<script src="js/my.extend.js" type="text/javascript"></script>
