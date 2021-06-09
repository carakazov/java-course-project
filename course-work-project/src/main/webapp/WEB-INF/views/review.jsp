<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 02.06.2021
  Time: 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Write your review</title>
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
    <h1>You can write your review here</h1>
    <form:form modelAttribute="review" method="post" action="/review">
        <div>
            <form:hidden path="propertyId"/>
            <form:hidden path="authorLogin"/>
            <label>Input your text</label>
            <form:textarea path="text"/>
            <form:errors path="text"/>
            <label>Input your score</label>
            <form:input path="score"/>
            <form:errors path="score"/>
        </div>
        <div>
            <button type="submit" class="button">Add</button>
        </div>
    </form:form>
</div>
</body>
</html>
