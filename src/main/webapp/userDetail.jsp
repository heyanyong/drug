<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/my.extend.js" type="text/javascript"></script>
<div class="pageContent">
	<form method="post" action="user/save"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input name="id" value="${user.id}" type="hidden" />
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
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
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>编号：</label> <input name="no" type="text" value="${user.no}" size="30"/>
			</p>
			<p>
				<label>姓名：</label> <input name="name" value="${user.name}" class="required" type="text"
					size="30"   alt="请输入客户名称" />
			</p>
			 
			
			<p>
				<label>性别：</label> <select name="sex" class="combox">
					<option value="">请选择</option>
					<option value="女">女</option>
					<option value="男">男</option>
				</select>
			</p>
			<p>
				<label>手机：</label> <input type="text" name="phone" size="30" value="${user.phone}" />
			</p>
			<p>
				<label>年龄：</label> <input type="text" name="age" size="30" value="${user.age}"/>
			</p>
			<p>
				<label>邮箱：</label> <input type="text" name="email" size="30" value="${user.email}" />
			</p>
			 
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd>
					<textarea name="remark" cols="95" rows="2" >${user.remark}</textarea>
				</dd>
			</dl>
		</div>

	</form>
</div>
