<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 01.06.2021
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Requests</title>
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
    <h1>All you received requests</h1>
    <c:forEach items="${list}" var="item">
        <div class="composition-block">
            <form:form
                    action="/request?propertyId=${item.propertyId}&buyerLogin=${item.senderLogin}&requestId=${item.requestId}"
                    method="post"
                    modelAttribute="result">
                Your composition title: <strong>${item.propertyTitle}</strong> <br>
                Buyer is: <a
                    href="/users/${item.senderLogin}">${item.senderInfo.surname} ${item.senderInfo.name} ${item.senderInfo.middleName}</a>
                <br>
                Contacts: ${item.senderInfo.email}<br>
                <form:checkbox path="result"/> Do you want to sell your rights?
                <button type="submit" class="button">Response</button>
            </form:form>
        </div>
    </c:forEach>
</div>
</body>
</html>
