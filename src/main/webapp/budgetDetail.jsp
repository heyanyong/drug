<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
table .list td{padding:0; border:none;  }
.floatLeft { float: left;}
</style>
<div class="pageHeader" style="border:1px #B8D0D6 solid">
	<form id="pagerForm" onsubmit="return divSearch(this, 'budgetDetail');" action="budget/detail" method="post">
	<input type="hidden" name="pageNum" value="1" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					<input type="radio" name="njjg" value="" checked="checked" />全部
					<input type="radio" name="njjg" value="1"/>可用
					<input type="radio" name="njjg" value="2"/>冻结
				</td>
				<td>
					科目名称：<input type="text" name="keyword" />
				</td>
				<td>
					科目编码：<input type="text" name="keyword" />
				</td>
				<td><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></td>
			</tr>
		</table>
	</div>
	</form>
</div>
<form action="budget/saveOrUpdate" id="budgetForm" onsubmit="return validateCallback(this)">
<input type="hidden" name="structure.id" value="${structrueId}" />
<input type="hidden" name="id" value="${info.id}" />
<div class="pageContent" layoutH="56" style="overflow: auto;">
<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" title="实要导出这些记录吗?"><span>EXCEL导入</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" onclick="saveUpdate()" ><span>保存更新</span></a></li>
		</ul>
	</div>
	<div style="overflow: auto;width: 1400px;">
	<table class="list nowrap itemDetail" addButton="追加条目" width="100%"  >
		<thead>
			<tr>
				<th type="del" >&nbsp;</th>
				<th type="lookup" lookupGroup="budgets[#index#]" lookupUrl="subject/list?show=dialog"   name="budgets[#index#].name" size="12" fieldClass="required floatLeft" >科目名称</th>
				<th type="text" name="budgets[#index#].no" size="11" fieldClass="required" >科目编码</th>
				<th type="text" name="budgets[#index#].january" id="budgets[#index#].january" size="9" fieldClass="number" defaultVal="0.0">一月</th>
				<th type="text" name="budgets[#index#].february" size="9" fieldClass="number" defaultVal="0.0">二月</th>
				<th type="text" name="budgets[#index#].march" size="9" fieldClass="number" defaultVal="0.0">三月</th>
				<th type="text" name="budgets[#index#].april" size="9" fieldClass="number" defaultVal="0.0">四月</th>
				<th type="text" name="budgets[#index#].may" size="9" fieldClass="number" defaultVal="0.0">五月</th>
				<th type="text" name="budgets[#index#].june" size="9" fieldClass="number" defaultVal="0.0">六月</th>
				<th type="text" name="budgets[#index#].july" size="9" fieldClass="number" defaultVal="0.0">七月</th>
				<th type="text" name="budgets[#index#].august" size="9" fieldClass="number" defaultVal="0.0">八月</th>
				<th type="text" name="budgets[#index#].september" size="9" fieldClass="number" defaultVal="0.0">九月</th>
				<th type="text" name="budgets[#index#].october" size="9" fieldClass="number" defaultVal="0.0">十月</th>
				<th type="text" name="budgets[#index#].november" size="9" fieldClass="number" defaultVal="0.0">十一月</th>
				<th type="text" name="budgets[#index#].december" size="9" fieldClass="number" defaultVal="0.0">十二月</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${info.budgets}" var="e" varStatus="es">
			<tr target="e_id" rel="${e.id}" class="unitBox">
					<td><a href="javascript:void(0)" class="btnDel ">删除</a></td>
					<td><input type="text" name="budgets[${es.index}].name" value="${e.name}"
						size="12" class="required textInput"></td>
					<td><input type="text" name="budgets[${es.index}].no" value="${e.no}"
						size="11" class="required textInput"></td>
					<td><input type="text" name="budgets[${es.index}].january" value="${e.january}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].february" value="${e.february}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].march" value="${e.march}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].april" value="${e.april}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].may" value="${e.may}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].june" value="${e.june}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].july" value="${e.july}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].august" value="${e.august}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].september" value="${e.september}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].october" value="${e.october}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].november" value="${e.november}"
						size="9" class="number textInput"></td>
					<td><input type="text" name="budgets[${es.index}].december" value="${e.december}"
						size="9" class="number textInput"></td>
						</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
</form>
<script>
 function saveUpdate(){
	 $("#budgetForm").submit();
 }
</script>