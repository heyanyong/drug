<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/my.extend.js" type="text/javascript"></script>
<script>
 var structure_id;
</script>
<div class="pageContent">
	<form id="detailForm" method="post" action="user/save"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" id="detailSubmit">保存</button>
						</div>
					</div></li>
			</ul>
		</div>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>账号：</label> <input name="no" type="text" size="30" />
			</p>
			<p>
				<label>姓名：</label> <input name="name" class="required" type="text"
					size="30" />
			</p>
			<p>
				<label>性别：</label> <select name="sex" class="combox">
					<option value="">请选择</option>
					<option value="女">女</option>
					<option value="男">男</option>
				</select>
			</p>
			<p>
				<label>部门名称：</label>
				<input type="hidden" name="structure.id" id="structure.id"/>
				<input type="text" class="required" name="structure.name" size="30"/>
				<a class="btnLook"  href="structureLookup.jsp" lookupGroup="structure"  width="300" >查找带回</a>		
			</p>
			<p>
				<label>角色：</label>
				<input type="hidden" name="userAdd_roleLK.id"/>
				<input type="text" class="required" name="userAdd_roleLK.orgName" value="" size="30"  lookupGroup="userAdd_roleLK" />
				<a class="btnLook" href="role/lookup" title="角色" lookupGroup="userAdd_roleLK">查找带回</a>		
			</p>
			<p>
				<label>手机：</label> <input type="text" name="phone" size="30" />
			</p>
			<p>
				<label>邮箱：</label> <input type="text" name="email" size="30" />
			</p>

			<p>
				<label>年龄：</label> <input type="text" name="age" size="30" />
			</p>
			<p>
				<label>出生日期：</label> <input type="text" name="birthday" class="date"
					size="30" dateFmt="yyyy-MM-dd" /><a class="inputDateButton"
					href="javascript:;">选择</a>
			</p>
			<p>
				<label>入职日期：</label> <input type="text" name="entryDate"
					class="date" size="30" dateFmt="yyyy-MM-dd" /><a
					class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<dl class="nowrap">
				<dt>备 注：</dt>
				<dd>
					<textarea name="remark" cols="95" rows="2"></textarea>
				</dd>
			</dl>

			<div class="divider"></div>
		</div>
	</form>
</div>
