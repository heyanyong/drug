<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="pay/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="no" value="${no}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="pay/list" method="post" rel=”pagerForm”>
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
			<li><a class="add" href="pay/add" rel="payAdd" target="navTab"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="pay/delete/{e_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="pay/edit/{e_id}" target="navTab"><span>查看表单</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li class="line">line</li>
			<li><a class="icon"  target="dwzExport" targetType="navTab"  ><span>刷新列表</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>编号</th> 
				<th>申请人</th> 
				<th>供应商</th> 
				<th>付款总记</th> 
				<th>风险类型</th> 
				<th>付款方式</th> 
				<th>创建日期</th>
				<th width="65">状态</th> 
				<th>操作</th> 
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td>${e.no}</td>
				<td>${e.createUser.name}</td>
				<td>${e.supplier.name}</td>
				<td>${e.payTotal}</td>
				<td>${e.riskType}</td>
				<td>${e.payType}</td>
				<td>${e.createDate}</td>
				<td><img src="images/status${e.status}.png" /></td>
				<td><c:if test="${e.status==2}"> <a href="flow/image/${e.flowId}" target="navTab">查看办理进度</a></c:if>
					<c:if test="${e.status==1}"> 
					<a href="pay/deal/${e.id}" target="ajaxTodo">办理</a> &nbsp;|&nbsp;
					<a href="pay/edit/${e.id}" target="navTab">修改</a> &nbsp;|&nbsp;
					<a href="pay/delete/${e.id}" target="ajaxTodo">作废</a>
					</c:if>
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