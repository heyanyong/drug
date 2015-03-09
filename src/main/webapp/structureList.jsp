<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="themes/zTreeStyle.css" type="text/css">
<script src="themes/jquery.ztree.core-3.5.js"></script>
<style>
  .container{padding:0;margin:0;}
  .container .col{width:30%; float: left;}
  .container .row{height:40px;}
</style>
<div class="container" style="margin-top:30px;">
	<div class="col " >
		<div class="zTreeDemoBackground" style="margin-left:40%;">
			<ul id="structrueTree" class="ztree"></ul>
		</div>
	</div>
	<div class="col ">
		<form>
		  <div class="row">
		    <label>当前节点：<input name="id" type="text" readonly="readonly" /></label>
		  </div>
		  <div class="row">
		    <label>节点名称：<input name="name" type="text" /></label>
		  </div>
		  <div class="row">
		    <label>节点编号：<input name="name" type="text" /></label>
		  </div>
		  <div class="row">
		  	<div class="button"><div class="buttonContent"><button onclick="save()">按钮</button></div></div>
		  	<div class="button"><div class="buttonContent"><button onclick="update()">按钮</button></div></div>
		  	<div class="button"><div class="buttonContent"><button onclick="deleteStructrue()">按钮</button></div></div>
		  </div>
		  
		</form>
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
			onClick : onClick,
			onMouseUp : onMouseUp
		}
	};

	function onClick(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("structrueTree");
		zTree.expandNode(treeNode);
	}
	function onMouseUp(event, treeId, treeNode) {
		$("[name='name']").val(treeNode.name);
		$("[name='id']").val(treeNode.id);
		$("[name='no']").val(treeNode.no);
	}
	
	function save() {
		if (confirm("确定要新增当前用户")) {
			var data={'id':"id",'name':"name",};
			$.post("structure/save",data,null);
		}
	}
	function update() {
		if (confirm("确定要修改当前用户")) {
			$("#structrueForm").attr("action", "update");
			$("#structrueForm").submit();
		}
	}
	function deleteStructrue() {
		if (confirm("确定要修改当前用户")) {
			$("#structrueForm").attr("action", "delete");
			$("#structrueForm").submit();
		}
	}
	$.ajax({
		type : "post",
		url : "structure/list",
		async : false,
		success : function(data) {
			$.fn.zTree.init($("#structrueTree"), setting, data);
		}

	});
</script>