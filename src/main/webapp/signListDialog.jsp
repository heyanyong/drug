<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<form id="pagerForm" method="post" action="echase/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>

<div class="pageHeader">
	<form onsubmit="return dwzSearch(this,'dialog');" action="sign/list?show=dialog" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					日期从：<input type="text" class="date" name="startDate" />
				</td>
				<td>
					到日期：<input type="text" class="date" name="endDate" />
				</td>
				<td>
					<div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="100">
		<thead>
			<tr>
				<th >日期</th>
				<th >上班时间</th>
				<th >下班时间</th>
				<th >状态</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td>${e.recordDate}</td>
				<td> <fmt:formatDate value="${e.signIn}" type="time"/> </td>
				<td> <fmt:formatDate value="${e.signOut}" type="time"/> </td>
				<td>${e.status}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示${pages.numPerPage}</span><span>条，共${pages.totalCount}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${pages.totalCount}" numPerPage="${pages.numPerPage}" pageNumShown="${pages.pageNumShown}" currentPage="${pages.currentPage}"></div>
	</div>
</div>
    