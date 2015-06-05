<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<h2 class="contentTitle">请选择需要上传的附件2</h2>
<form method="post" action="upload/formUpload" enctype="multipart/form-data">
	<input type="text" name="name" /> 
	<input type="file" name="file" /> 
	<input type="submit" />
</form>
