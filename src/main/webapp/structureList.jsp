<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="themes/zTreeStyle.css" type="text/css">
<script src="themes/jquery.ztree.core-3.5.js"></script>
<style>
  .container{padding:0;margin:0;}
  .container .col{width:40%; float: left;}
  .container .row{height:50px;}
  .container .button {margin-right:20px;}
</style>
<div class="container" style="margin-top:40px;">
	<div class="col " >
		<div class="zTreeDemoBackground" style="margin-left:40%;">
			<ul id="structrueTree" class="ztree"></ul>
		</div>
	</div>
	<div class="col " id="structureForm" style="padding-top:50px;">
		  <div class="row">
		    <label>当前节点：<input name="id" type="text" readonly="readonly" /></label>
		  </div>
		  <div class="row">
		    <label>节点名称：<input name="name" type="text" /></label>
		  </div>
		  <div class="row">
		  	<div class="button"><div class="buttonContent"><button onclick="save()">新增</button></div></div>
		  	<div class="button"><div class="buttonContent"><button onclick="update()">更新</button></div></div>
		  	<div class="button"><div class="buttonContent"><button onclick="deleteNode()">删除</button></div></div>
		  </div>
		  
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
		if(treeNode.isParent==true){
		$("[name='name']").val(treeNode.name);
		$("[name='id']").val(treeNode.id);
		nodeName=treeNode.name;
		nodeId=treeNode.id;
		nodePid=treeNode.pId;
		}
	}
	
	function save() {
		var pId=$("[name='id']").val();
		var name=$("#structureForm  [name='name']").val();
		alertMsg.confirm("确定要在\""+nodeName+"\"节点下面新增\""+name+"\"节点吗？", {
			okCall: function(){
				var data={'pId':pId,'name':name};
				$.post("structure/save", data, DWZ.ajaxDone, "json");
				setTimeout(function(){navTab.reload();},700); 
			}
		});
	}
	function update() {
		var name=$("#structureForm [name='name']").val();
		alertMsg.confirm("确定要更新\""+nodeName+"\"节点为\""+name+"\"吗？", {
			okCall: function(){
				var data={'id':nodeId,'name':name,'pId':nodePid};
				$.post("structure/update", data, DWZ.ajaxDone, "json");
				navTab.reload();
			}
		});
	}
	function deleteNode() {
		alertMsg.confirm("确定要删除\""+nodeName+"\"节点吗？", {
			okCall: function(){
				var data={'id':nodeId};
				$.post("structure/delete", data, DWZ.ajaxDone, "json");
				setTimeout(function(){navTab.reload();},700);
			}
		});
	}
	$.ajax({
		type : "post",
		url : "structure/list?all=1",
		async : false,
		success : function(data) {
			$.fn.zTree.init($("#structrueTree"), setting, data);
		}

	});
</script>