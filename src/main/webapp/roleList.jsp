<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="user/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="role/list" method="post" rel=”pagerForm”>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					名称：<input type="text" name="name"  />
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
			<li><a class="add" href="roleAdd.jsp" target="dialog"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="export/delete/{e_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="role/edit/{e_id}" target="navTab"  rel="roleDeatil"><span>设置角色权限</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li class="line">line</li>
			<li><a class="icon"   target="dwzExport" targetType="navTab"  ><span>查看流程</span></a></li>
			<li class="line">line</li>
			<li><a class="icon"  target="dwzExport" targetType="navTab"  ><span>刷新列表</span></a></li>
		</ul>
	</div>
	<table class="table" width="40%" layoutH="113">
		<thead>
			<tr>
				<th width="25"></th>
				<th>角色名</th> 
				<th>流程级别</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td><input type="checkbox" /></td>
				<td>${e.name}</td>
				<td>${e.grade}</td>
				<td><a class="edit" href="role/edit/${e.id}" target="navTab"  rel="roleDeatil"><span>设置权限</span></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>共${pages.totalCount}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${pages.totalCount}" numPerPage="${pages.numPerPage}" pageNumShown="${pages.pageNumShown}" currentPage="${pages.currentPage}"></div>
	</div>
</div>