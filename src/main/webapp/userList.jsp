<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="user/list">
	<input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="user/list" method="post" rel=”pagerForm”>
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					 姓名：<input type="text" name="Q_t.name_like" value="" />
				</td>
				<td>
					工号：<input type="text" name="Q_t.no_like" value="" />
				</td>
				<td>
					<select class="combox" name="Q_t.sex_like">
						<option value="">所有</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</td>
				<td>
					入职日期从：<input type="text" class="date" name="Q_t.entryDate_>=_date" readonly="true" />
				</td>
				<td>
					到入职日期：<input type="text" class="date" name="Q_t.entryDate_>=_date" readonly="true" />
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
			<li><a class="add" href="userAdd.jsp" target="navTab"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="user/delete/{e_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="user/edit/{e_id}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="user/reset/{e_id}" target="navTab"  title="实要导出这些记录吗?"><span>重置密码</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" onclick="navTab.reload();" ><span>刷新列表</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="113">
		<thead>
			<tr>
				<th width="25"></th>
				<th>账号</th>	<th>姓名</th>
				<th>性别</th><th>部门</th>
				<th>角色</th>	<th>手机</th>
				<th>年龄</th>	<th>生日</th>
				<th>邮箱</th>
				<th>入职日期</th><th>创建人</th>
				<th>创建日期</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${pages.data}" var="e">
			<tr target="e_id" rel="${e.id}">
				<td><input type="checkbox" /></td>
				<td>${e.no}</td>
				<td><a href="user/edit/${e.id}" target="navTab" rel="user${e.id}" >${e.name}</a></td>
				<td>${e.sex}</td>
				<td>${e.structure.name}</td>
				<td>${e.roles}</td>
				<td>${e.phone}</td>
				<td>${e.age}</td>
				<td>${e.birthday}</td>
				<td>${e.email}</td>
				<td>${e.entryDate}</td>
				<td>${e.createUser.name}</td>
				<td>${e.createDate}</td>
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
