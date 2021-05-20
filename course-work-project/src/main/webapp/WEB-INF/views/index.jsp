<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 02.05.2021
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${session.personalInfo.name} ДОБРО ПОЖАЛОВАТЬ НА СЕРВЕР ШИЗОФРЕНИЯ</h1>
<div>
    <a href="/logout">Logout</a>
    <a href="/users/${session.login}">Private page</a>
</div>
</body>
</html>
