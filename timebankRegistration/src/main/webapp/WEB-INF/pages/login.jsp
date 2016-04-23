
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
  <form:form commandName="user">
    <table>
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
    </table>

    <input type="submit" value="Sign Up" />

  </form:form>

  <a href="/timebank/users">All Users</a>    |    <a href="/timebank/login">Login</a>    |    <a href="/timebank/">Sign Up</a>
</body>
</html>
