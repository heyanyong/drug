<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<form id="pagerForm" method="post" action="echase/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>

<div class="pageHeader">
	<form action="upload/one?up=1" method="post" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this)">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td >
					<input type="hidden"  name="createUser.id" value="${loginUser.id}" />
					<label>文件：</label> <input type="file" name="image" class="required" size="30" />
				</td>
			</tr>
			<tr>
				<td>
					<div class="buttonActive"  ><div class="buttonContent"><button type="submit">保 存</button></div></div>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="100" nowrapTD="false">
		<thead>
			<tr>
				<th width="130">保存日期</th>
				<th >文件名</th>
				<th width="50">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr>
				<td><fmt:formatDate value="" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td></td>
				<td>&nbsp;<c:if test="">
				<a href="notice/ignore?id=${e.id}" target="ajaxTodo"  callback="$.pdialog.reload('notice/list?show=dialog', {data:{}, dialogId:'noticeListDialog', callback:null}) ">忽略</a> 
				</c:if></td>
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
    