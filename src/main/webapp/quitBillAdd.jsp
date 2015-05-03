<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="pageContent">
	<form id="detailForm" method="post" action="quit/save" 
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><a class="buttonActive" href="javascript:saveBill('detailForm');"><span>保存</span></a></li>
			</ul>
		</div>
		<div class="pageFormContent quitBill" layoutH="56">
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
				<label>最后工作日期：</label>
				<input type="text" name="lastWorkDate" class="date required"   size="30" dateFmt="yyyy-MM-dd"  /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>离职类型：</label> <select name="type" class="combox required">
					<option value="">请选择</option>
					<option value="自愿离职" selected="selected">自愿离职</option>
					<option value="合同终止">合同终止</option>
					<option value="解雇">解雇</option>
				</select>
			</p>
			<p>
				<label>工作交接人：</label>
				<input type="hidden" name="cadidate.id" />
				<input type="text"  name="cadidate.name" size="30"   readonly="readonly" lookupGroup="cadidate" />
				<a class="btnLook" href="user/lookup" lookupGroup="cadidate">查找带回</a>		
			</p>
			<dl class="nowrap">
				<dt>离职说明：</dt>
				<dd>
					<textarea name="reason" cols="95" rows="6" class="required" ></textarea>
				</dd>
			</dl>
		
<div class="divider"></div>
<div class="information">
			 <p>
				<label>创建人：</label> <input  type="text" readonly="readonly" value="${user.createUser.name}" />
			</p>
			 <p>
				<label>创建人账号：</label> <input  type="text" readonly="readonly" value="${user.createUser.no}" />
			</p>
			 <p>
				<label>最后更新人：</label> <input  type="text" readonly="readonly" value="${user.updateUser.name}" />
			</p>
			 <p>
				<label>更新人账号：</label> <input  type="text" readonly="readonly" value="${user.updateUser.no}" />
			</p>
			 <p>
				<label>最后更新时间：</label> <input  type="text" readonly="readonly" value="${user.updateTime}" />
			</p>
			</div>
			</div>
	</form>
</div>
<script>
 function saveBill(form){
	 $("#"+form).attr("action","quit/save");
	 $("#"+form).submit();
 }
 function dealBill(form){
	 $("#"+form).attr("action","quit/deal");
	 $("#"+form).submit();
 }
 function getDate(strDate) {
     var st = strDate;
     var a = st.split(" ");
     var b = a[0].split("-");
     var c = a[1].split(":");
     var date = new Date(b[0], b[1], b[2], c[0], c[1], c[2])
     return date;
 }
 function calculateHours(){
	    var startDate=$(".quitBill input[name='startDate']").val();
	    var endDate=$(".quitBill input[name='endDate']").val();
	    if(startDate!="" && endDate!=""){
		    var hours=getDate(endDate).getTime()-getDate(startDate).getTime();
		    $(".quitBill input[name='hours']").val(Math.ceil(hours/(1000*3600)));
	    }
 }


</script>