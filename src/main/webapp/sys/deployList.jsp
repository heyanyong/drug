<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="pagerForm" method="post" action="sysurl/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="sysurl/list" method="post" rel=”pagerForm”>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					姓名：<input type="text" name="name" value="${name}" />
				</td>
				<td>
					入职日期：<input type="text" class="date" readonly="true" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="sys/deploy.jsp" rel="deploy" target="dialog"><span>部署流程</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" onclick="navTab.reload();" ><span>刷新列表</span></a></li>
		</ul>
	</div>
	<table class="table" width="50%" layoutH="138">
		<thead>
			<tr>
				<th width="25"></th>
				<th>ID</th> 
				<th>名称</th> 
				<th>部署时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td><input type="checkbox" /></td>
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td><fmt:formatDate value='${e.getDeploymentTime()}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
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