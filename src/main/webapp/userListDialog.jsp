<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<form id="pagerForm" method="post" action="echase/list">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form onsubmit="return dwzSearch(this,'dialog');" action="user/list?show=dialog" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					工号：<input type="text"   name="Q_t.no_like" />
				</td>
				<td>
					姓名：<input type="text"   name="Q_t.name_like" />
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
				<th >工号</th>
				<th >姓名</th>
				<th >电话</th>
				<th >邮箱</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td>${e.no}</td>
				<td>${e.name}</td>
				<td>${e.phone}</td>
				<td>${e.email}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
    