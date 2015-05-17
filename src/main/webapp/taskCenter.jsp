<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form id="pagerForm"
	onsubmit="return divSearch(this, 'personTaskList');"
	action="flow/taskList" method="post">
	<input type="hidden" name="pageNum" value="1" />
	<div class="panelBar">
		<ul class="toolBar">
			<li class="line">line</li>
			<li><a href="flow/taskList" target="ajax" rel="personTaskList" class="icon"><span>待办任务</span></a></li>
			<li class="line">line</li>
			<li><a href="flow/historyTaskList" target="ajax" rel="personTaskList" class="icon"><span>已办任务</span></a></li>
		</ul>
	</div>
 <table class="table" width="99%" layoutH="314"
	rel="personTaskList">
	<thead>
	 <tr>
	   <th>创建时间</th>
	   <th>所属部门</th>
	   <th>发起人</th>
	   <th>任务标题</th>
	   <th>任务情况</th>
	   <th>跟踪</th>
	 </tr>
	</thead>
  <tbody>
	<c:forEach items="${taskPage.data}" var="e">
		<tr target="sid_obj" rel="${e[0]}">
			<td width="130"><a
				href="${e[9]}/edit/${e[10]}?dealer=${e[2]}&processInstanceId=${e[5]}&taskId=${e[0]}&taskDes=${e[12]}"
				target="navTab"><fmt:formatDate value="${e[3]}" pattern='yyyy-MM-dd HH:mm:ss' /></a></td>
			<td width="100"><a
				href="${e[9]}/edit/${e[10]}?dealer=${e[2]}&processInstanceId=${e[5]}&taskId=${e[0]}&taskDes=${e[12]}"
				target="navTab">${e[6]}</a></td>
			<td width="80"><a
				href="${e[9]}/edit/${e[10]}?dealer=${e[2]}&processInstanceId=${e[5]}&taskId=${e[0]}&taskDes=${e[12]}"
				target="navTab">${e[7]}</a></td>
			<td><a
				href="${e[9]}/edit/${e[10]}?dealer=${e[2]}&processInstanceId=${e[5]}&taskId=${e[0]}&taskDes=${e[12]}"
				target="navTab">${e[8]}</a></td>
			<td>${e[11]}</td>
			<td width="30"><a href="flow/track/${e[5]}" rel="track/${e[5]}" target="navTab" title="流程跟踪"><img alt="" src="images/flowView.png" /></a></td>
		</tr>
	</c:forEach>
  </tbody>
 </table>
	<div class="panelBar">
		<div class="pages"> 
		</div>
		<div class="pagination" rel="personTaskList" totalCount="${taskPage.totalCount}"
			numPerPage="${taskPage.numPerPage}" pageNumShown="${taskPage.pageNumShown}"
			currentPage="${taskPage.currentPage}"></div>
	</div>
</form>