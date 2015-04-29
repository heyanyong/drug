<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent article" layoutH="97">
	<h2>${info.name}</h2>
	<div class="base"><span>${info.createDate }</span><span>${info.createUser.name }</span></div>
	 <div class="divider"></div>
	 <div class="content">
	   ${info.content }
	 </div>
</div>
<script>
/*  var h=$(".pageContent").height();
 $(".article .content").height(h-30); */
</script>