<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome <%= session.getAttribute("uname") %> !</h1>
	<br>
	<%
		if(session.getAttribute("uname").equals("admin")) {
	%>
			<a href="userdetails.jsp">Manage Users</a>
	<%
		}
	%>
	<br>
	<a href="logout.jsp">Logout</a>
</body>
</html>