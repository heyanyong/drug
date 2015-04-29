<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	
	<form method="post" action="subject/save" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>科目名称：</label>
				<input type="text" name="name" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>科目编号：</label>
				<input type="text" name="no" size="30" class="required"/>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提 交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">返 回</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>

