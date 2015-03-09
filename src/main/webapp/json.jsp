<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="js/jquery-1.7.2.js" type="text/javascript"></script>
<body>
	<h1>12</h1>
</body>
<script>
$(document).ready(
		
		function() {	
			$.ajax({
				type : "post",
				url : "<%=path%>/structure/list",
				async : false,
				success : function(data) {
					var cToObj=JSON.stringify(data); 
					nodes=cToObj.replace(/"(\w+)"(\s*:\s*)/g, "$1$2");
					alert(nodes);
				}
			});
		});
</script>
