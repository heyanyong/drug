
function editCtrl(page, taskDes) {
	$(page + " :input").attr("disabled", "disabled");
	var reg = /\([^\)]+\)/g;
	var arr;
	while ((arr = reg.exec(taskDes)) != null) {
		var field = new String(arr);
		var inStr=field.substring(1, field.length - 1);
		$(page + " :input[name='"+inStr+"']").removeAttr("disabled");
	}
}

function jqchk(){ //jquery获取复选框值 
	var chk_value =[]; 
	$('input[name="test"]:checked').each(function(){ 
	chk_value.push($(this).val()); 
	}); 
	alert(chk_value.length==0 ?'你还没有选择任何内容！':chk_value); 
	} 

function toPurchase(){
	var chk_value =[];
	$('input[name="ids"]:checked').each(function(){ 
		chk_value.push($(this).val()); 
		}); 
	if(chk_value.length==0){
		alert("请勾选数据");
	}else{
		navTab.openTab("navTab", "drug/toPurchase", { title:"生成采购需求单", fresh:false, data:{ids:chk_value.toString()} });
	}
}
function toExport(){
	var chk_value =[];
	$('input[name="ids"]:checked').each(function(){ 
		chk_value.push($(this).val()); 
	}); 
	if(chk_value.length==0){
		alert("请勾选数据");
	}else{
		navTab.openTab("navTab", "drug/toExport", { title:"生成出库单", fresh:false, data:{ids:chk_value.toString()} });
	}
}
$(".information input").attr("readonly","readonly");

function addRow(tid) {
	var tbody = $("#" + tid).children("tbody");
	var trInner=tbody.children("tr:last");
	var td=trInner.html();
	var str=td.match(/drugs\[\d\]/);
	var numStr=new String(str);
	var numtext=numStr.match(/\d/);
	var num=new Number(numtext);
	td=td.replace(/drugs\[\d\]/g,"drugs["+(num+1)+"]");
	tbody.append("<tr>"+td+"</tr>");
}
function removeRow(tid){
	var tbody = $("#" + tid).children("tbody");
	var len=(tbody.children("tr")).length;
	if(len>1){
		tbody.children("tr:last").remove();
	}else{
		alert("不能删除首行");
	}
}