<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="js/my.extend.js" type="text/javascript"></script>
<div class="pageContent">
	<form id="detailForm" method="post" action="user/save" 
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input name="id" value="${user.id}" type="hidden" />
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit" id="detailSubmit">保存</button>
						</div>
					</div></li>
			</ul>
		</div>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>账号：</label> <input name="no" type="text" value="${user.no}" size="30"/>
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
				<label>部门：</label> <input type="text"  size="30" value="${user.phone}" />
			</p>
			<p>
				<label>角色：</label> <input type="text"  size="30" value="${user.phone}" />
			</p>
			<p>
				<label>手机：</label> <input type="text" name="phone" size="30" value="${user.phone}" />
			</p>
			<p>
				<label>邮箱：</label> <input type="text" name="email" size="30" value="${user.email}" />
			</p>
			 
			<p>
				<label>年龄：</label> <input type="text" name="age" size="30" value="${user.age}"/>
			</p>
			 <p>
				<label>出生日期：</label>
				<input type="text" name="birthday" class="date" size="30" dateFmt="yyyy-MM-dd" value="${user.birthday}" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			 <p>
				<label>入职日期：</label>
				<input type="text" name="entryDate" class="date" size="30" dateFmt="yyyy-MM-dd" value="${user.entryDate}"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<dl class="nowrap">
				<dt>备 注：</dt>
				<dd>
					<textarea name="remark" cols="95" rows="2" >${user.remark}</textarea>
				</dd>
			</dl>
		
<div class="divider"></div>
<div class="information">
			 <p>
				<label>创建人：</label> <input  type="text" value="${user.createUser.name}" />
			</p>
			 <p>
				<label>创建人账号：</label> <input  type="text" value="${user.createUser.no}" />
			</p>
			 <p>
				<label>最后更新人：</label> <input  type="text" value="${user.updateUser.name}" />
			</p>
			 <p>
				<label>更新人账号：</label> <input  type="text" value="${user.updateUser.no}" />
			</p>
			 <p>
				<label>最后更新时间：</label> <input  type="text" value="${user.updateTime}" />
			</p>
			</div>
			</div>
	</form>
</div>
<script>
  if("${user.id}"){
	  $("#detailForm").attr("action","user/update");
	  $("#detailSubmit").text("更新");
	  $(".information input").attr("readonly","readonly");
  }else{
	  $(".information").remove();
  }

</script>