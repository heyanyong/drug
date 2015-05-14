<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="themes/zTreeStyle.css" type="text/css">
<div class="pageContent">
	<form id="taskTransferForm" method="post" action="flow/transfer" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="58">
			<div style="width:320px; overflow: auto; float: left;">
				<ul id="strTaskTransferTree" class="ztree"></ul>
			</div>
			<div  style=" overflow: auto; float: left;">
			<input type="hidden" name="taskId" value="${param.taskId}" />
			<input type="hidden" name="assigneeId" />
			 转交人：<br /><br />
			 <input type="text" name="assignee" />
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确认转交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
	var setting = {
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onMouseUp : onMouseUp
		} 
	};
	function onMouseUp(event, treeId, treeNode) {
		if(!treeNode.isParent==true){
			//取值问题
			$("#taskTransferForm [name='assignee']").val(treeNode.name);
			$("[name='assigneeId']").val(treeNode.id);
		}else{
			var zTree = $.fn.zTree.getZTreeObj("strTaskTransferTree");
			zTree.expandNode(treeNode);
		}
	}
	
	$.ajax({
		type : "post",
		url : "structure/list?all=1",
		async : false,
		success : function(data) {
			$.fn.zTree.init($("#strTaskTransferTree"), setting, data);
		}
	});
</script>