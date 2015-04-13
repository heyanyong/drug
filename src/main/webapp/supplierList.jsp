<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="supplier/list">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="supplier/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					名称：<input type="text" name="Q_t.name_like" value="" />
				</td>
				<td>
					编号：<input type="text" name="Q_t.no_like" value="" />
				</td>
				<td>
					所属客户：<input type="text" name="Q_t.customer.name_like" value="" />
				</td>
				<td>
					建档日期：<input type="text" class="date" readonly="true" />
				</td>
				<td>
					<div class="buttonActive"><div class="buttonContent"><button type="submit">检 索</button></div></div>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="supplier/add" target="navTab"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="supplier/delete/{e_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="supplier/edit/{e_id}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" onclick="navTab.reload();" ><span>刷新列表</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="113">
		<thead>
			<tr>
				<th width="10"></th>
				<th width="120">客户号</th>
				<th>客户名称</th>
				<th width="100">客户类型</th>
				<th >所属客户</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td></td>
				<td>${e.no}</td>
				<td>${e.name}</td>
				<td>1</td>
				<td>${e.customer.name}</td>
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
    