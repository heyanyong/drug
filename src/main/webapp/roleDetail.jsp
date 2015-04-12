<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

 .roleEditPage .col{float:left; width:23%; margin-left:10px;margin-top:10px;height:500px; overflow: auto;}
 .roleEditPage .col select{width:100%; height:400px;}
 .roleEditPage .col ul{border:1px solid #ccc;}
 .roleEditPage .col li,.roleEditPage .col option{padding:5px; display: block;}
 .roleEditPage .col h3{text-align: center; letter-spacing: 2px; padding: 5px; }
 .roleEditPage .col3{background: white; width:110px;padding-top: 80px;border:none}
 .roleEditPage .col span {text-align:center;display:block; width:100px; background:#eee; cursor:pointer; border:1px solid #ccc; padding:5px 0; margin:5px 0;}
</style>

<div class="roleEditPage">
<form action="role/update" onsubmit="return validateCallback(this, navTabAjaxDone);" method="post" id="roleDetailForm">
	<div class="formBar" >
	 <a class="button" href="javascript:formSubmit();" id="detailSubmit" style="float: right;"><span>更 新</span></a>
	</div>
	<div class="col">
	  <h3>角色列表</h3>
	  <ul>
	    <c:forEach items="${roleList}" var="role">
	      <li><a href="role/edit/${role.id}" target="navTab" rel="roleDeatil" >${role.name}</a></li>
	    </c:forEach>
	  </ul>
	</div>
	<div class="col">
	  <h3>系统权限</h3>
		<select multiple="multiple" id="sysUrl">
			 <c:forEach items="${sysUrls}" var="su">
				<option value="${su.id}">${su.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col col3">
 		<span id="addUrl">添加权限&gt;&gt;</span><br />
 		<span id="removeUrl">&lt;&lt;移除权限</span><br /> 
 		<span id="remove_allUrl">移除所有</span><br /> 
	</div>
	<div class="col" id="col3role">
      <h3>角色权限</h3>
       <input type="hidden" name="id" value="${info.id}" />
       <input type="hidden" name="name" value="${info.name}" />
		<select multiple="multiple" id="roleUrl" >
			<c:forEach items="${info.urls}" var="ru">
				<option value="${ru.id}">${ru.name}</option>
			</c:forEach>
		</select>
	</div>
	</form>
</div>

<script>
$(document).ready(function(){
	$(".roleEditPage #detailSubmit").click(function() {
		var all=$("#roleUrl option");
		$("#roleUrl option").each(function(i){
			$("#col3role").append("<input type='hidden' name='roleUrls' value='"+this.value+"' />");
		});
		$("#roleDetailForm").submit();
	});
	$("#addUrl").click(function() {
		$("#sysUrl option:selected").appendTo("#roleUrl");
	});
	$("#removeUrl").click(function() {
		$("#roleUrl option:selected").appendTo("#sysUrl");
	});
	$("#remove_allUrl").click(function() {
		$("#roleUrl option").appendTo("#sysUrl");
	});
	$("#sysUrl").dblclick(function() {
		$("#sysUrl option:selected").appendTo("#roleUrl");
	});
	$("#roleUrl").dblclick(function() {
		$("#roleUrl option:selected").appendTo("#sysUrl");
	});
});
</script>