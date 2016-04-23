
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Add skills</title>
</head>
<body>
	<form:form commandName="skills">

		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>

			<tr>
				<td>Category</td>
				<td><form:input path="category" /></td>
				<td><form:errors path="category" /></td>
			</tr>
		</table>

		<input type="submit" value="Add skill" />

	</form:form>

	<a href="/timebank/users">All Users</a>    |    <a href="/timebank/login">Login</a>    |    <a href="/timebank/">Sign Up</a>
</body>
</html>