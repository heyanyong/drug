<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="contract/save">
<input name="name" type="text" />
<input name="createDate" type="text" />
<input name="updateDate" type="text" /><br />
0<input name="drugs[0].name" type="text"/>
1<input name="drugs[1].name" type="text"/>
<input type="submit" value="保存" />
</form>
</body>
</html>