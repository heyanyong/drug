<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="themes/zTreeStyle.css" type="text/css">
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<div>
			<ul id="structrueLLKTree" class="ztree"></ul>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
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
			$.bringBack({id:treeNode.id, name:treeNode.name});
	}
	
	$.ajax({
		type : "post",
		url : "structure/list",
		async : false,
		success : function(data) {
			$.fn.zTree.init($("#structrueLLKTree"), setting, data);
		}
	});
</script>