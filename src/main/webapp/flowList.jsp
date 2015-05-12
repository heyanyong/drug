<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<form id="pagerForm" method="post" action="flow/flowList">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="flow/flowList" method="post" rel=”pagerForm”>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					名称：<input type="text" name="name" value="${name}" />
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
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="deploy.jsp" target="dialog"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="export/delete/{e_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="icon"  target="dwzExport" targetType="navTab"  ><span>刷新列表</span></a></li>
		</ul>
	</div>
	<table class="table" width="60%" layoutH="110">
		<thead>
			<tr>
				<th>流程名称</th> 
				<th>版本</th> 
				<th>查看流程图</th> 
				<th>说明</th> 
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td>${e.name}</td>
				<td>${e.version}</td>
				<td> <a href="flow/img?deploymentId=${e.deploymentId}&&imageName=process/${e.key}.png" target="_blank">查看流程图</a></td>
				<td>${e.description}</td>
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