<%@page import="com.dao.Dao,com.bean.RegisterBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>User Details</h1>
	<%
		Dao dao = new Dao();
		List<RegisterBean> list = dao.getAllRecords();
		request.setAttribute("list", list);
	%>
	
	<table border="1">
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Address</th>
		<th colspan="2">Options</th>
	</tr>
	<c:forEach items="${list }" var="l">
		<tr>
			<td><c:out value="${l.getUname() }"/></td>
			<td><c:out value="${l.getEmail() }"/></td>
			<td><c:out value="${l.getAddress() }"/></td>
			<td><a href="edit.jsp?name=${l.getUname() }">Edit</a></td>
			<td><a href="delete.jsp?name=${l.getUname() }">Delete</a></td>
		</tr>
	</c:forEach>
	</table>

	<br>
	<a href="success.jsp">Return to menu.</a>

</body>
</html>