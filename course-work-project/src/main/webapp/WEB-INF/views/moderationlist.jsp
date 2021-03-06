<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="mytag/show" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 24.05.2021
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moderator page</title>
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
<div class="center-body"></div>
<h1>New compositions list</h1>
<c:forEach items="${items}" var="item">
    <div class="composition-block">
        <mytag:showTag property="${item.property}"/>
        <div class="moderation-console">
            <a href="/moderating/approve/${item.propertyId}" class="button">Approve</a>
            <a href="/moderating/decline/${item.propertyId}" class="button">Decline</a>
        </div>
    </div>
</c:forEach>
</div>
</body>
</html>
