<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<form id="pagerForm" method="post" action="subject/list">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form onsubmit="return dwzSearch(this,'dialog');" action="subject/list?show=dialog" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					编号：<input type="text"   name="Q_t.no_like" />
				</td>
				<td>
					名称：<input type="text"   name="Q_t.name_like" />
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
				<th >点击选择</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td>${e.no}</td>
				<td>${e.name}</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({no:'${e.no}', name:'${e.name}'})" title="查找带回">选择</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
    