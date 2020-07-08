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
		if(session.getAttribute("error") != null) {
			out.println(session.getAttribute("error"));
		}
		session.removeAttribute("error");
	%>
	
	<form method="post" action="register.do">
		<table border="1">
			<tr>
				<td>Username</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register"></td>
			</tr>
		</table>
	
	</form>
</body>
</html>