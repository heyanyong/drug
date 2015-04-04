<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageHeader">
	<form onsubmit="return dwzSearch(this,'dialog');" action="sysurl/save" method="post">
	 <div class="pageContent">
	 <table class="table" width="100%" layoutH="100">
		<tr>
		  <td>name:</td>
		  <td><input name="name" type="text" /></td>
		</tr>
		<tr>
		  <td>url:</td>
		  <td><input name="url" type="text" /></td>
		</tr>
	</table>
	   <input type="submit" /><br />
	 </div>
	</form>
</div>
 