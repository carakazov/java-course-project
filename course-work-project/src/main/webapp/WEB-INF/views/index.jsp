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
    <title>Index Page</title>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
</head>
<body>
<header>
    <div><h1>REEL DIR</h1></div>
    <nav>
        <a href="/users/${session.login}">User</a>
        <a href="/logout">Logout</a>
    </nav>
</header>
<div>
    <h1>SERVER IS UNDER ATTACK</h1>
</div>
</body>
</html>
