<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2 class="contentTitle">请选择需要部署的流程压缩包</h2>
<form action="flow/deploy" method="post" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>流程名称：</dt><dd><input type="text" name="flowName" class="required" size="30" /></dd>
		</dl>
		<dl>
			<dt>ZIP文件：</dt><dd><input type="file" name="image" class="required" size="30" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">部 署</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
		</ul>
	</div>
</div>
</form>