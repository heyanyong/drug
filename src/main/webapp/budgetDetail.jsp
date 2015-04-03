<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="pageHeader" style="border:1px #B8D0D6 solid">
	<form id="pagerForm" onsubmit="return divSearch(this, 'budgetDetail');" action="demo/pagination/list1.html" method="post">
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

<div class="pageContent" style="height:500px;  overflow: auto;">
<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" title="实要导出这些记录吗?"><span>EXCEL导入</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<div style="width:300px ; height:500px; overflow: auto;">
	<table class="list nowrap itemDetail" addButton="添加1条记录"  >
		<thead>
			<tr>
				<th type="text" name="items[#index#]" size="12" fieldClass="required" >科目名称</th>
				<th type="text" name="items[#index#]" size="12" fieldClass="required" >科目编码</th>
				<th type="text" name="items[#index#]" size="1" fieldClass="number">一月</th>
				<th type="text" name="items[#index#]" size="1" fieldClass="number">二月</th>
				<th type="text" name="items[#index#]" size="1" fieldClass="number">三月</th>
				<th type="text" name="items[#index#]" size="1" fieldClass="number">四月</th>
				<th type="text" name="items[#index#]" size="6" fieldClass="number">五月</th>
				<th type="text" name="items[#index#]" size="6" fieldClass="number">六月</th>
				<th type="text" name="items[#index#]" size="6" fieldClass="number">七月</th>
				<th type="text" name="items[#index#]" size="6" fieldClass="number">八月</th>
				<th type="text" name="items[#index#]" size="6" fieldClass="number">九月</th>
				<th type="text" name="items[#index#]" size="6" fieldClass="number">十月</th>
				<th type="text" name="items[#index#]" size="6" fieldClass="number">十一月</th>
				<th type="text" name="items[#index#]" size="6" fieldClass="number">十二月</th>
				<th type="del" width="60">操作</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	</div>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox')">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共50条</span>
		</div>
		
		<div class="pagination" rel="jbsxBox" totalCount="200" numPerPage="20" pageNumShown="5" currentPage="1"></div>

	</div>
</div>