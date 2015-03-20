<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<form id="pagerForm"
		onsubmit="return divSearch(this, 'personTaskList');"
		action="flow/taskList" method="post">
		<input type="hidden" name="pageNum" value="1" />
	
<div class="pageContent"
	style="border-left: 1px #B8D0D6 solid; border-right: 1px #B8D0D6 solid">
	<div class="panelBar" style="height: 30px;">
		<ul class="toolBar">
			<li><a class="icon" href=""><span>待办</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href=""><span>已办</span></a></li>
			<li class="line">line</li>
			<li><input type="text" name="name" /></li>
			<li><div class="buttonActive">
					<div class="buttonContent">
						<button type="submit">查 询</button>
					</div>
				</div></li>
		</ul>
	</div>
	<table class="table" width="99%" layoutH="315" rel="personTaskList">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th >诊所编号</th>
				<th >诊所编号</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${taskList}" var="e">
			<tr target="sid_obj" rel="${e[0]}">
				<td width="20">${e[1]}</td>
				<td>${e[1]}</td>
				<td>${e[0]}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span> 共50条</span>
		</div>
		<div class="pagination" rel="jbsxBox"	totalCount="${pages.totalCount}"	numPerPage="${pages.numPerPage}"
		pageNumShown="${pages.pageNumShown}"	currentPage="${pages.currentPage}"></div>

	</div>
</div>
</form>