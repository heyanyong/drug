<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="themes/zTreeStyle.css"
	type="text/css">
<script src="themes/jquery.ztree.core-3.5.js"></script>
123
<div class="zTreeDemoBackground">
	<ul id="structrueTree" class="ztree"></ul>
</div>

<script type="text/javascript">
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick,
				onMouseUp: onMouseUp
			}
		};

		var zNodesEval = [{'id':1,'name':'业务一部','pid':0},{'id':2,'name':"业务二部",'pId':1},{'id':3,"name":"业务二部",'pId':1},{"id":4,"name":"业务三部","pid":3}];
		//var zNodesEval =null;
		function onClick(e,treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("structrueTree");
			zTree.expandNode(treeNode);
		}
		function onMouseUp(event, treeId, treeNode) {
			$("[name='name']").val(treeNode.name);
			$("[name='id']").val(treeNode.id);
			$("[name='address']").val(treeNode.address);
			$("[name='no']").val(treeNode.no);
			//$.post("${ctx}/structrue/get/2", function(data){
			//	   alert("Data: " + data);
			//	 });
			//$("#structrueFrame").src="../../jsp/base/right.jsp"
			//alert(treeNode.id+" onMouseUp " + treeNode.name+":"+treeNode.type);
		}
		$(document).ready(function() {		
			$.ajax({
				type : "post",
				url : "structure/list",
				async : false,
				success : function(data) {
					var str = JSON.stringify(data);
					alertr(str);
				}
				
			});
			
			//alert(zNodes);
			//zNodesEval=eval('(' + zNodes + ')');
			$.fn.zTree.init($("#structrueTree"), setting, zNodesEval);
		});
	
		
		function save(){
			if(confirm("确定要新增当前用户")){
				$("#structrueForm").attr("action","save");
				$("#structrueForm").submit();
			}
		}
		function update(){
			if(confirm("确定要修改当前用户")){
				$("#structrueForm").attr("action","update");
				$("#structrueForm").submit();
			}
		}
		function deleteStructrue(){
			if(confirm("确定要修改当前用户")){
				$("#structrueForm").attr("action","delete");
				$("#structrueForm").submit();
			}
		}
</script>