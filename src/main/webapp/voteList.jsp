<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="echase/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="vote/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					我的客户：<input type="text" name="keyword" />
				</td>
				<td>
					建档日期：<input type="text" class="date" readonly="true" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="vote/add" rel="voteAdd" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="vote/delete?id={e_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="vote/edit/{e_id}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="vote/fromPurchase?echaseId={e_id}" target="navTab" targetType="navTab"> <span>生成采购合同</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="vote/fromPurchase?echaseId={e_id}" target="navTab" targetType="navTab"> <span>查看流程</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="vote/view/{e_id}" target="navTab" > <span>查看</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th ></th>
				<th>标题</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>显示投票人</th>
				<th>是否开启</th>
				<th>创建时间</th>
				<th>创建人</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td></td>
				<td>${e.name}</td>
				<td>${e.startTime}</td>
				<td>${e.endTime}</td>
				<td>${e.isShowVoter==true? "是":"否"}</td>
				<td>${e.isOpen==true? "是":"否"}</td>
				<td>${e.createDate}</td>
				<td>${e.createUser.name}</td>
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
    