<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pageContent">
	<form id="detailForm" method="post" action="enrol/save" 
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><a class="buttonActive" href="javascript:saveBill('detailForm');"><span>保存</span></a></li>
			</ul>
		</div>
		<div class="pageFormContent enrolBill" layoutH="56">
			<p>
				<label>编号：</label> <input name="no" type="text" readonly="readonly" value="${no}" size="30"/>
			</p>
			<p>
				<label>申请人：</label> <input   value="${loginUser.name}" readonly="readonly" type="text"	size="30"/>
			</p>
			<p>
				<label>申请工号：</label> <input   value="${loginUser.no}" readonly="readonly" type="text"	size="30"/>
			</p>
			<p>
				<label>部门：</label> <input type="text"  size="30" readonly="readonly" value="${loginUser.name}" />
			</p>
			<p>
				<label>需求人数：</label> <input type="text" size="30" name="number" />
			</p>
			<p>
				<label>角色类型：</label> <input type="text" size="30" name="position" />
			</p>
			<p>
				<label>期限日期：</label>
				<input type="text" name="endDate"  class="date required" size="30" dateFmt="yyyy-MM-dd HH:mm:ss"   /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>需求类型：</label> <select name="type" class="combox">
					<option value="">请选择</option>
					<option value="增员">增员</option>
					<option value="补员">补员</option>
				</select>
			</p>
			<p>
				<label>角色层次：</label> <select name="type" class="combox">
					<option value="">请选择</option>
					<option value="普通员工" selected="selected">普通员工</option>
					<option value="管理层">管理层</option>
					<option value="决策层">决策层</option>
				</select>
			</p>
			<p>
				<label>角色：</label>
				<input type="text"  name="roleName" size="30" value=""  readonly="readonly" lookupGroup="cadidate" />
				<a class="btnLook" href="enrol/lookup" lookupGroup="role">查找带回</a>		
			</p>
			<dl class="nowrap">
				<dt>用人要求：</dt>
				<dd>
					<textarea name="requirement" cols="95" rows="6" ></textarea>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd>
					<textarea name="reason" cols="95" rows="6" ></textarea>
				</dd>
			</dl>
		
<div class="divider"></div>
<div class="information">
			 <p>
				<label>创建人：</label> <input  type="text" readonly="readonly"   />
			</p>
			 <p>
				<label>创建人账号：</label> <input  type="text" readonly="readonly"  />
			</p>
			 <p>
				<label>最后更新人：</label> <input  type="text" readonly="readonly"   />
			</p>
			 <p>
				<label>更新人账号：</label> <input  type="text" readonly="readonly"  />
			</p>
			 <p>
				<label>最后更新时间：</label> <input  type="text" readonly="readonly"   />
			</p>
			</div>
			</div>
	</form>
</div>
<script>
 function saveBill(form){
	 $("#"+form).attr("action","enrol/save");
	 $("#"+form).submit();
 }
 function dealBill(form){
	 $("#"+form).attr("action","enrol/deal");
	 $("#"+form).submit();
 }
</script>