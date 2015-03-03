<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="drug/list" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>我的客户：</label>
				<input type="text" name="keywords" value=""/>
			</li>
			<li>
			<select class="combox" name="province">
				<option value="">所有省市</option>
				<option value="北京">北京</option>
				<option value="上海">上海</option>
				<option value="天津">天津</option>
				<option value="重庆">重庆</option>
				<option value="广东">广东</option>
			</select>
			</li>
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><button type="button" class="checkboxCtrl" group="ids" >全选</button></li>
			<li class="line">line</li>
			<li><button type="button" class="checkboxCtrl" group="ids" selectType="invert">反选</button></li>
			<li class="line">line</li>
			<li><a class="edit" onclick="toPurchase();" ><span>生成采购需求</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" onClick="toExport();" ><span>生成出库单</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="drug/detail/{sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" onclick="navTab.reload();" ><span>刷新列表</span></a></li>
		</ul>
	</div>
	<table class="table" width="1200" layoutH="138">
		<thead>
			<tr>
				<th  >&nbsp;</th>
				<th   orderField="accountNo" class="asc">编号</th>
				<th orderField="accountName">名称</th>
				<th  orderField="accountType">库存</th>
				<th   orderField="accountCert">已出库数</th>
				<th   align="center">单位</th>
				<th  >入库日期</th>
				<th  >生产日期</th>
				<th  >过期日期</th>
				<th  >操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pages.data}" var="drug">
				<tr target="sid_user" rel="${drug[0]}" <c:if test="${drug[10]=='1'}"> style="color:red;" </c:if> >
				<td><input name="ids" value="${drug[0]}" type="checkbox"></td>
				<td>${drug[0]}</td>
				<td>${drug[1]}</td>
				<td>${drug[2]}</td>
				<td>${drug[3]}</td>
				<td>${drug[4]}</td>
				<td>${drug[5]}</td>
				<td>${drug[8]}</td>
				<td>${drug[9]}</td>
				<td>
					<c:if test="${drug[8]=='1'}"><img src="themes/alertDay.png" title="快要过期" alt="快要过期" /></c:if>
					<c:if test="${drug[9]=='1'}"><img src="themes/alertNum.png" title="库存不多" alt="库存不多"/></c:if>
					<c:if test="${drug[10]=='1'}"><img src="themes/expire.png" title="已过期" alt="已过期" /></c:if>
				</td>
			</tr>
			</c:forEach>
			
			 
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>
<script src="js/my.extend.js" type="text/javascript"></script>