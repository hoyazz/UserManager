<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.dao.Dao,com.bean.RegisterBean" %>
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
		RegisterBean rb = dao.getUserByName(name);
	%>
	
	<h1>Edit Data</h1>
	<form method="post" action="edit.do">
		<input type="hidden" name="uname" value="<%= rb.getUname() %>" >
		<table border="1">
			<tr>
				<td>Name</td>
				<td><%= rb.getUname() %></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd" value="<%= rb.getPwd() %>"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="<%= rb.getEmail() %>"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="<%= rb.getAddress() %>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Modify"></td>
			</tr>
		</table>
	</form>
</body>
</html>