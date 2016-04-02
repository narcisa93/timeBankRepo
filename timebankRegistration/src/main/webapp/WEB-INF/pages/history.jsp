
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User History</title>
</head>
<body>
  <ul>
    <c:forEach var="history" items="${histories}">
      <li>${history.getLoginTime()}</li>
    </c:forEach>
  </ul>

  <a href="/timebank/users">All Users</a>    |    <a href="/timebank/login">Login</a>    |    <a href="/timebank/">Sign Up</a>
</body>
</html>
