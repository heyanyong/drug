<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="flow/complete" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<input type="hidden" name="processInstanceId" value="${param.processInstanceId}" />
		<input type="hidden" name="taskId" value="${param.taskId}" />
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label></label>
				<input type="radio" name="outcome" value="1" class="required" /> 同意
				<input type="radio" name="outcome" value="0" /> 不同意
			</div>
			<div class="unit">
				 批注: <br /><br />
				<textarea name="comment" cols="85" rows="8" ></textarea>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交办理</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>
