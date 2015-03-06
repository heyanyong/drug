<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pageContent">
	<form id="detailForm" method="post" action="expense/save" 
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
				<label>编号：</label> <input name="no" type="text" value="${no}" size="30"/>
			</p>
			<p>
				<label>姓名：</label> <input name="name" type="text"	size="30"   />
			</p>
			 <p>
				<label>开始日期：</label>
				<input type="text" name="createDate" class="date" size="30" dateFmt="yyyy-MM-dd"  /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<!-- <p>
				<label>开始日期：</label>
				<input type="text" name="udateDate" class="date" size="30" dateFmt="yyyy-MM-dd HH:mm:ss"  /><a class="inputDateButton" href="javascript:;">选择</a>
			</p> -->
			</div>
	</form>
</div>
<script>
 

</script>