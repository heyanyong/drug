<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
<h2>login</h2>
${loginMsg}
<form action="checkLogin" method="post">
 <input name="no"/>
 <input name="password" type="password"/>
 <input type="submit"></input>
</form>
</body>
</html>
