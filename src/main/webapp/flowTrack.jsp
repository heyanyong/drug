<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程跟踪</title>
<style>
 
.conlogtab{margin-top:30px;   overflow: auto; margin-left:10px; }
.conlogtab table {     width:90%; }
.conlogtab td{ border:1px solid #a1cbee;word-wrap:break-word;line-height: 20px; padding:5px; }
.conlogtab .tabtitle{white-space: nowrap;line-height: 20px; width:17%; text-align: center;background: #f6f5fb;font-weight: bold; letter-spacing: 2px;}
</style>
</head>
<body>
<div class="pageContent" layoutH="7">
	<div class="conlogtab">
		<table>
			<tr>
				<td class="tabtitle">当前办理情况</td>
				<td>${current}</td>
			</tr>
		</table>
	</div>
	<iframe src="flow/image/${flowId}"   style="width:96% ; height:400px; overflow: auto;border:none; margin-left:10px;">
</iframe>
</div>
</body>
</html>