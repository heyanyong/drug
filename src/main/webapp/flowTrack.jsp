<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程跟踪</title>
</head>
<body>
<div style="width:100% ; height:50px; padding:10px 20px; font-size: 2em;">
  <span style="font-weight: bold;font-size: 2em;">当前办理人</span>  ${current}
</div>
<iframe src="flow/image/${flowId}"   style="width:100% ; height:400px; overflow: auto;border:none;">
</iframe>
</body>
</html>