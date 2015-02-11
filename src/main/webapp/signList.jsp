<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@Page language="java" import="com.gxuts.wss.dms.base.Page" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sign list</title>
</head>
<body>
	<c:forEach items="${pages.data}" var="user">
${user.id} &nbsp;${user.userName}&nbsp;${user.userNo}&nbsp;${user.signIn}&nbsp;${user.signOut}<br />
	</c:forEach>
	${pages.currentPage} 
	${pages.total}
	${pages.rows}
	<br />
	<%
 		   request.getAttribute("pages");
 	%>

	<c:set value="<%=5%>" var="num1"></c:set>
  
	<c:forEach var="i" begin="1" end="${num1}">
		<a href="list?currentPage=${i}&row=2">${i}</a>
	</c:forEach>
	<script type="text/javascript">
 
	</script>
</body>
</html>