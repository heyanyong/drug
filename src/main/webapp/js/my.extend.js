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

 