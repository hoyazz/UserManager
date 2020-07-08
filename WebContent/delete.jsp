<%@page import="com.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		Dao dao = new Dao();
		dao.deleteUser(name);
		response.sendRedirect("userdetails.jsp");
	%>
	
</body>
</html>