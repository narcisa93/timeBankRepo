
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Sign Up Here</title>
</head>
<body>
	<form:form commandName="user">

		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:input path="gender" /></td>
				<td><form:errors path="gender" /></td>
			</tr>
			
			<tr>
				<td>Phone number</td>
				<td><form:input path="phoneNumber" /></td>
				<td><form:errors path="phoneNumber" /></td>
			</tr>
		</table>

		<input type="submit" value="Sign Up" />

	</form:form>

	<a href="/timebank/users">All Users</a>    |    <a href="/timebank/login">Login</a>    |    <a href="/timebank/">Sign Up</a>
</body>
</html>