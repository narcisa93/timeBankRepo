
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Profile</title>
</head>
<body>
<form:form commandName="user">
	<table>
		<tr>
			<td> <img src="/timebank/upload" alt="Smiley face" height="200" width="200"/></a></td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${user.getFullName()}</td>
		</tr>

		<tr><td>Email</td>
		<td>${user.getEmail()}</td>
		</tr>
		<tr>
		<td>Phone</td>
		<td>${user.getPhoneNumber()}</td>

		</tr>
	</table>
	</form:form>

	<br />
	<a href="/timebank/users">All Users</a> |
	<a href="/timebank/login">Login</a> |
	<a href="/timebank/">Sign Up</a>
</body>
</html>
