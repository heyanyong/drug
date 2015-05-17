<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pageHeader">
	<form onsubmit="return dialogSearch(this,'dialog');" action="sysurl/save" method="post">
	 <div class="pageContent">
	 <table class="table" width="100%" layoutH="50">
		<tr>
		  <td width="150">权限名称:</td>
		  <td><input name="name" type="text" class="required"/></td>
		</tr>
		<tr>
		  <td>权限url:</td>
		  <td><input name="url" type="text" class="required"/></td>
		</tr>
		<tr height="50px">
		  <td colspan="2" ><input type="submit" /><br /></td>
		</tr>
	</table>
	 </div>
	</form>
</div>
 