<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" href="themes/zTreeStyle.css" type="text/css">
<script src="themes/jquery.ztree.core-3.5.js"></script>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>

<div class="pageContent" style="padding:5px">
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>预算维护</span></a></li>
					<li><a href="javascript:;"><span>维护说明</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>
				<div layoutH="30" style="float:left; display:block; overflow:auto; width:210px; border:solid 1px #CCC; line-height:21px; background:#fff">
					 <ul id="structrueTree" class="ztree"></ul>
				</div>
				
				<div id="budgetDetail" class="unitBox" style="margin-left:216px;">
					<!--#include virtual="list1.html" -->
				</div>
	
			</div>
			
			<div>维护说明</div>
			
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
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
		$("#budgetDetail").loadUrl("budget/detail/"+treeNode.id,null, null);
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