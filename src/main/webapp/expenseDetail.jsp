<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<style type="text/css" media="screen">
.my-uploadify-button {
	background:none;
	border: none;
	text-shadow: none;
	border-radius:0;
}

.uploadify:hover .my-uploadify-button {
	background:none;
	border: none;
}

.fileQueue {
	min-height: 58px;
	overflow: auto;
	border: 1px solid #E5E5E5;
	margin-bottom: 10px;
}
</style>
<div class="pageContent">
	<form id="detailForm" method="post" action="expense/update" 
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="formBar">
			<ul>
				<li><a class="buttonActive" href="javascript:saveBill('detailForm');"><span>保存</span></a></li>
				<li><a class="buttonActive" href="dealTask.jsp?processInstanceId=${param.processInstanceId}&taskId=${param.taskId}" target="dialog" ><span>办理任务</span></a></li>
			</ul>
		</div>
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>基本信息</legend>
			<p>
				<label>单据编号：</label>
				<input name="no" type="text"   value="${no}" readonly="readonly" name="no" size="30"/>
			</p>
			<p>
				<label>提交人：</label>
				<input name="name" class="required" type="text" size="30" readonly="readonly" value="${loginUser.name}"/>
			</p>
			<p>
				<label>提交部门：</label>
				<input name="structureName" type="text" size="30" readonly="readonly" value="${loginUser.structure.name}"/>
			</p>
			<p>
			<label>付款方式：</label>
				<select name="type" class="required combox">
					<option value="">请选择</option>
					<option value="个人">现金付款</option>
					<option value="个人">支票付款</option>
					<option value="公司" selected>银行存款</option>
				</select>
			</p>
			</fieldset>
			<fieldset>
				<legend>相关信息</legend>
			<p>
				<label>开发人员：</label>
				<input name="devUser"  type="text" size="30" value="${loginUser.name }"/>
			</p>
			<p>
				<label>开发部门：</label>
				<input name="devDepartment" value="${loginUser.name }"  type="text" size="30"/>
			</p>
			</fieldset>
			<fieldset>
				<legend>其它信息</legend>
			<p>
				<label>营业执照号：</label>
				<input type="text" name="certificationNo" size="30" />
			</p>
			<p>
				<label>公司成立日期：</label>
				<input type="text" name="foundDate" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>所属行业：</label>
				<input type="text" name="industry"  size="30" />
			</p>
			<p>
				<label>法人姓名：</label>
				<input type="text" size="30" name="legalPerson" />
			</p>
			<dl class="nowrap">
				<dt>主要经营产品：</dt>
				<dd>
					<textarea name="textarea1" cols="88" rows="2" name="mainBusiness"></textarea>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd>
					<textarea name="textarea1" cols="88" rows="2" name="remark"></textarea>
				</dd>
			</dl>
			</fieldset>
			 <fieldset>
				<legend>附件信息</legend>
					 <input id="testFileInput2" type="file" name="image2" 
		uploaderOption="{
			swf:'uploadify/scripts/uploadify.swf',
			uploader:'upload/some?up=1',
			formData:{up:'test', ajax:1},
			queueID:'fileQueue',
			buttonImage:'uploadify/img/add.jpg',
			buttonClass:'my-uploadify-button',
			removeCompleted:false, 
			width:102,
			auto:true,
			onUploadSuccess:function(file, data, response){
			  oneFileUp(file, data, response);
			},
			onCancel:function(file){alert(1);} 
		}"
	/>
	
	<div id="fileQueue" class="fileQueue"></div>
	<!-- 
	<input type="image" src="uploadify/img/upload.jpg" onclick="$('#testFileInput2').uploadify('upload', '*');"/>
	<input type="image" src="uploadify/img/cancel.jpg" onclick="$('#testFileInput2').uploadify('cancel', '*');"/>
 -->
				
			</fieldset>
			<div class="comments" >
			<table class="table"  >
			<thead>
			  <tr>
			    <th width="200">审批</th>
			    <th width="200">办理人</th>
			    <th width="400">办理时间</th>
			    <th>批注</th>
			  </tr>
			</thead>
			<tbody>
			<c:forEach items="${comments}" var="e">
			  <tr>
			    <td>${e[0]}</td>
			    <td>${e[1]}</td>
			    <td><fmt:formatDate value="${e[2]}" type="date"/>--<fmt:formatDate value="${e[3]}" type="date"/></td>
			    <td>${e[4]}</td>
			  </tr>
			  </c:forEach>
			  </tbody>
			</table>
			</div>
		</div>
				
	</form>
</div>
<script>
 var row=0;
 function oneFileUp(file, data, response) {
	 f=eval('(' + data + ')');
	 //alert('路径' + f.webPath+ '名字' + f.fileName+ '类型' + f.fileType);  
	 $("#detailForm").append("<input type='hidden' name='files["+row+"].webPath' value='"+f.webPath+"' />");
	 $("#detailForm").append("<input type='hidden' name='files["+row+"].fileName' value='"+f.fileName+"' />");
	 $("#detailForm").append("<input type='hidden' name='files["+row+"].fileType' value='"+f.fileType+"' />");
	 row++;
 }
</script>