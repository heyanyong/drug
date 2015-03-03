<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
  .editTable{}
  .editTable th{text-align: center; font-size: 12px;}
</style>

<div class="pageContent">
	<form method="get" action="purchase/update"
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
				<label>编号：</label> <input name="no" type="text" size="30" readonly="readonly" value="${info.no}"/>
				<input name="id" type="hidden" value="${info.id}"/>
			</p>
			<p>
				<label>提交人：</label> <input    type="text" 
					size="30"    readonly="readonly"  value="${info.createUser.name}"/>
			</p>
			<p>
				<label>提交工号：</label> <input   type="text" 
					size="30"    readonly="readonly"  value="${info.createUser.no}"/>
			</p>
			<p>
				<label>提交部门：</label> <input name="name"   type="text" 
					size="30"   readonly="readonly"  value="${info.createUser.no}" />
			</p>
			<p>
				<label>采购主体：</label> <input name="name" class="required" type="text" 
					size="30" value="广西科技大学卫生所" />
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
				<label>采购方式：</label> <input type="text" size="30" name="purchaseWay"/>
			</p>
			<p>
				<label>完成日期：</label> <input type="text" name="completeDate"
					class="date" size="30" /><a class="inputDateButton"
					href="javascript:;">选择</a>
			</p>
			<p>
				<label>采购方式：</label> <select name="capital"   class="required combox">
					<option value="">请选择</option>
					<option value="招标采购"> 招标采购 </option>
					<option value="非招标采购" selected> 非招标采购 </option>
				</select> 
			</p>
			<p>
				<label>注册类型：</label> <input type="text" size="30" />
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd>
					<textarea name="remark" cols="95" rows="2"></textarea>
				</dd>
			</dl>
			<div class="divider"></div>
			<div class="panel collapse" minH="100" >
				<h1>药品明细 <span class="addRowt"   onclick="addRow('purchaseEditsub');">添加行<b>+</b></span><span class="delRowt" onclick="removeRow('purchaseEditsub');">删除行-</span></h1>
				<div>
					<table class="editTable" id="purchaseEditsub">
							<thead>
								<tr>
									<th>&nbsp;</th>
									<th>编号</th>
									<th>名称</th>
									<th>需求数量</th>
									<th>单位</th>
									<th>规格</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${info.drugs}" var="e">
								<tr>
									<td><input type="checkbox" name="rowHead" /></td>
									<td><input type="text" name="drugs[0].no"  /></td>
									<td><input type="text" name="drugs[0].name" value="${e.name }" /></td>
									<td><input type="text" name="drugs[0].requestNumber"  /></td>
									<td><input type="text" name="unit"  size="10"/></td>
									<td><input type="text" name="looks"  size="30"/></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
				
				</div>
			</div>

		</div>

	</form>
</div>
<script src="js/my.extend.js" type="text/javascript"></script>
