<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="comments">
	<table>
		<thead>
			<tr>
				<th width="130">流程节点</th>
				<th width="80">办理人</th>
				<th width="155">办理时间</th>
				<th width="35">结果</th>
				<th>批 注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${comments}" var="e">
				<tr>
					<td>${e[0]}</td>
					<td><code>${e[1]}</code></td>
					<td>
					开始：<fmt:formatDate value='${e[2]}' pattern='yyyy-MM-dd HH:mm:ss' /><br /> 
					 结束：<fmt:formatDate value="${e[3]}" pattern='yyyy-MM-dd HH:mm:ss' /></td>
					<td>${e[4]}</td>
					<td>${e[5]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>