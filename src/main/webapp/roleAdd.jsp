<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<form id="pagerForm" method="post" action="echase/list">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="name" value="${name}" />
</form>

<div class="pageHeader">
	<form onsubmit="return dwzSearch(this,'dialog');" action="sign/list?show=dialog" method="post">
	<div class="searchBar">
		
	</div>
	</form>
</div>
<div class="pageContent">
<table>
			<tr>
				<td>
					日期从：<input type="text" class="date" name="startDate" />
				</td>
				</tr>
				<tr>
				<td>
					到日期：<input type="text" class="date" name="endDate" />
				</td>
				</tr>
				<tr>
				<td>
					<div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div>
				</td>
			</tr>
		</table>
</div>
    