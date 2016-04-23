<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>News Feed</title>
    <style>
div.posts {
    background-color:black;
    color:white;
    margin:20px;
    padding:20px;
} 
</style>
</head>
<body>
    <c:forEach var="project" items="${projects}">
     <div class="posts"><p>${project.getUser().getFullName ()} offers ${project.getTitle()}</p><button>Apply</button></div>
    </c:forEach>
  <a href="/timebank/users">All Users</a>    |    <a href="/timebank/login">Login</a>    |    <a href="/timebank/">Sign Up</a>
</body>
</html>