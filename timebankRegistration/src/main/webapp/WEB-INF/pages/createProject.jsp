
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Create new project</title>
</head>
<body>
	<form:form commandName="project">

		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title" /></td>
				<td><form:errors path="title" /></td>
			</tr>

			<tr>
				<td>Desription</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" /></td>
			</tr>
			<tr>
				<td>Offered time for each activity:</td>
				<td><form:input path="offeredTime" /></td>
				<td><form:errors path="offeredTime" /></td>
			</tr>
		</table>

		<input type="submit" value="Create project" />

	</form:form>

	<a href="/timebank/users">All Users</a>    |    <a href="/timebank/login">Login</a>    |    <a href="/timebank/">Sign Up</a>
</body>
</html>