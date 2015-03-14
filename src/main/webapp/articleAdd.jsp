<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="article/save"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>基本信息</legend>
				<p>
					<label>客 编号：</label> <input name="no" type="text" value="${no}"
						readonly="readonly" name="no" size="30" />
				</p>
				<p>
					<label>标题：</label> <input name="name" class="required"
						type="text" size="30" />
				</p>
				<p>
					<label>简称：</label> <input name="simpleName" type="text" size="30" />
				</p>
				<p>
					<label>类型：</label> <select name="type" class="required combox">
						<option value="">请选择</option>
						<option value="行业资讯">行业资讯</option>
						<option value="公司资讯" selected>公司资讯</option>
						<option value="通知公告" selected>通知公告</option>
					</select>
				</p>
			</fieldset>
			<fieldset>
				<legend>详细内容</legend>
				<textarea class="editor" name="content" rows="23" cols="100"
					upLinkUrl="upload/editor?up=1"
					upLinkExt="zip,rar,txt,doc,xls,ppt,pdf"
					upImgUrl="upload/editor?up=1" upImgExt="jpg,jpeg,gif,png"
					upFlashUrl="upload/editor?up=1" upFlashExt="swf"
					upMediaUrl="upload/editor?up=1"upMediaExt:"avi">
					</textarea>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
