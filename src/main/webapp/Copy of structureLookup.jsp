<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="user/lookup">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="user/lookup" onsubmit="return dwzSearch(this, 'dialog');">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>部门:</label>
				<input class="textInput" name="orgName" value="" type="text">
			</li>	  
			<li>
				<label>角色:</label>
				<input class="textInput" name="orgNum" value="" type="text">
			</li>
			<li>
				<label>姓名:</label>
				<input class="textInput" name="fullName" value="" type="text">
			</li>
				<li>
				<label>工号:</label>
				<input class="textInput" name="parentOrg.orgName" value="" type="text">
			</li> 
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th orderfield="orgName">部门</th>
				<th orderfield="orgNum">角userLookup.jsp色</th>
				<th orderfield="userName">姓名</th>
				<th orderfield="userNo">工号</th>
				<th width="80">点击选择</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr>
				<td> ${e.name}</td>
				<td> ${e.name}</td>
				<td> ${e.name}</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({id:'${e.id}', userName:'${e.name}'})" title="查找带回">选择</a>
				</td>
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