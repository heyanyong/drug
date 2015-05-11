<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<form id="pagerForm" method="post" action="echase/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>

<div class="pageHeader">
	<form onsubmit="return validateCallback(this, dialogAjaxDone)" action="notice/save" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td colspan="2">
					<input type="hidden"  name="createUser.id" value="${loginUser.id}" />
					<label>提醒日期：</label>
					<input type="text" class="date" style="float:left;" name="alertTime" dateFmt="yyyy-MM-dd HH:mm:ss"/>
					 	<a class="inputDateButton" href="javascript:;">选择</a>
				</td>
			</tr>
			<tr>
				<td>
					<label>备忘内容：</label><textarea   name="content" rows="3" cols="60" class="required" ></textarea>
				</td>
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
				<th width="130">提醒日期</th>
				<th >内容</th>
				<th width="50">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td><fmt:formatDate value="${e.alertTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${e.content}</td>
				<td>&nbsp;<c:if test="${e.isAvailable==true}"><a href="notice/ignore?id=${e.id}" target="ajaxTodo"  callback="$.pdialog.reload('notice/list?show=dialog', {data:{}, dialogId:'noticeListDialog', callback:null}) ">忽略</a> </c:if></td>
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
    