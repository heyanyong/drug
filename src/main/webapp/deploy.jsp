<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h2 class="contentTitle">请选择包含“流程名.bpmn和流程名.png的压缩包zip”附件</h2>

<form action="demo/database/db_attachmentBrightBack.html" method="post" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this, $.bringBack)">

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>zip附件：</dt><dd><input type="file" name="image" class="required" size="30" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">上 传</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关 闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>