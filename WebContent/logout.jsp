<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% session.invalidate(); %>
	<h1>Logged out successfully.</h1>
	<a href="login.jsp">Click here to return to login page.</a>
</body>
</html>