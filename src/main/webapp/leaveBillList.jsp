<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="user/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="no" value="${no}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="user/list" method="post" rel=”pagerForm”>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					编号：<input type="text" name="name" value="${no}" />
				</td>
				<td>
					日期：<input type="text" class="date" readonly="true" />
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
			<li><a class="add" href="leave/add" rel="leaveAdd" target="navTab"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="leave/delete/{e_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="leave/edit/{e_id}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="leave/deal/{e_id}" target="ajaxTodo"><span>办理</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="flow/image/{e_id}"   targetType="navTab"  ><span>查看流程</span></a></li>
			<li class="line">line</li>
			<li><a class="icon"  target="dwzExport" targetType="navTab"  ><span>刷新列表</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>编号</th> 
				<th>创建日期</th>
				<th>申请人</th> 
				<th>部门</th> 
				<th>请假小时数</th> 
				<th>交接人</th> 
				<th>状态</th> 
				<th>操作</th> 
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td>${e.no}</td>
				<td>${e.createDate}</td>
				<td>${e.createUser.name}</td>
				<td>${e.createUser.structure.name}</td>
				<td>${e.hours}</td>
				<td>${e.no}</td>
				<td>${e.status}</td>
				<td><a href="flow/image/${e.flowId}" target="navTab">查看办理进度</a></td>
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