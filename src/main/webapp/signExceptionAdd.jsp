<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pageContent">
	<form id="detailForm" method="post" action="signException/save" 
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><a class="buttonActive" href="javascript:saveBill('detailForm');"><span>保存</span></a></li>
			</ul>
		</div>
		<div class="pageFormContent signExceptionBill" layoutH="56">
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
				<label>开始日期：</label>
				<input type="text" name="startDate" class="date required"   size="30" dateFmt="yyyy-MM-dd HH:mm:ss"  /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>结束日期：</label>
				<input type="text" name="endDate"  class="date required" size="30" dateFmt="yyyy-MM-dd HH:mm:ss"   /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>总小时数：</label> <input type="text"    size="30" name="hours" onclick="calculateHours()" />
			</p>
			<p>
				<label>请假类型：</label> <select name="type" class="combox">
					<option value="">请选择</option>
					<option value="事假" selected="selected">事假</option>
					<option value="补休假">补休假</option>
					<option value="年假">年假</option>
					<option value="产假">产假</option>
				</select>
			</p>
			<p>
				<label>工作交接人：</label>
				<input type="hidden" name="cadidate.id" />
				<input type="text"  name="cadidate.name" size="30" value=""  readonly="readonly" lookupGroup="cadidate" />
				<a class="btnLook" href="signException/lookup" lookupGroup="cadidate">查找带回</a>		
			</p>
			<dl class="nowrap">
				<dt>请假说明：</dt>
				<dd>
					<textarea name="reason" cols="95" rows="6" ></textarea>
				</dd>
			</dl>
		
<div class="divider"></div>
<div class="information">
			 <p>
				<label>创建人：</label> <input  type="text" readonly="readonly" value="${signException.createUser.name}" />
			</p>
			 <p>
				<label>创建人账号：</label> <input  type="text" readonly="readonly" value="${signException.createUser.no}" />
			</p>
			 <p>
				<label>最后更新人：</label> <input  type="text" readonly="readonly" value="${signException.updateUser.name}" />
			</p>
			 <p>
				<label>更新人账号：</label> <input  type="text" readonly="readonly" value="${signException.updateUser.no}" />
			</p>
			 <p>
				<label>最后更新时间：</label> <input  type="text" readonly="readonly" value="${signException.updateTime}" />
			</p>
			</div>
			</div>
	</form>
</div>
<script>
 function saveBill(form){
	 $("#"+form).attr("action","signException/save");
	 $("#"+form).submit();
 }
 function dealBill(form){
	 $("#"+form).attr("action","signException/deal");
	 $("#"+form).submit();
 }
</script>