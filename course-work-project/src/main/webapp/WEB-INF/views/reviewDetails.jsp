<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 02.06.2021
  Time: 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review</title>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
</head>
<body>
<header>
    <div><a class="logo" href="/">REEL DIR</a></div>
    <nav>
        <a href="/users/${session.login}">Account</a>
        <a href="/logout">Logout</a>
    </nav>
</header>
<div class="center-body">
    <h1>Here you can read full review</h1>
    <p>
        ${details.text}
    </p>
    <label>Final score: ${details.score}</label>
</div>
</body>
</html>
