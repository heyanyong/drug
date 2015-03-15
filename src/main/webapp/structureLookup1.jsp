<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link rel="stylesheet" href="themes/zTreeStyle.css" type="text/css">
<script src="themes/jquery.ztree.core-3.5.js"></script>
<div class="pageContent" style="background: #eef4f5;">
	<div >
		<ul id="structrueULKTree" class="ztree"></ul>
	</div>
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button class="close">确认</button></div></div></li>
			</ul>
		</div>

</div>
<script type="text/javascript">
	var nodeName="";
	var nodeId="";
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
		$("[name='structure.id']").val(treeNode.id);
		$("[name='structure.name']").val(treeNode.name);
	}
	
	 
	$.ajax({
		type : "post",
		url : "structure/list",
		async : false,
		success : function(data) {
			$.fn.zTree.init($("#structrueULKTree"), setting, data);
		}
	});
	var outh =$(".dialogContent").height();
	$("#structrueULKTree").height(outh-50);
	
</script>