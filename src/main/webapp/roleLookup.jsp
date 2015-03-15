<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" action="demo/database/dwzOrgLookup2.html">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="role/lookup" onsubmit="return dwzSearch(this, 'dialog');">
	<div class="searchBar">
	<table class="searchContent">
			<tr>
				<td>
					角色名：<input type="text"   name="name" />
				</td>
				<td>
					<div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div>
				</td>
				<td>
					<div class="button"><div class="buttonContent"><button type="button" multLookup="orgId" warn="请勾选角色">选择带回</button></div></div>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>
<div class="pageContent">

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th width="30"><input type="checkbox" class="checkboxCtrl" group="orgId" /></th>
				<th >角色名</th>
			</tr>
		</thead>
		<tbody>
			 <c:forEach items="${pages.data}" var="e">
			<tr>
				<td><input type="checkbox" name="orgId" value="{id:'${e.id}', orgName:'${e.name}'}"/></td>
				<td>${e.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="panelBar">
		<div class="pages">
			<span>共${pages.totalCount}个角色</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${pages.totalCount}" numPerPage="${pages.numPerPage}" pageNumShown="${pages.pageNumShown}" currentPage="${pages.currentPage}"></div>
	</div>
</div>