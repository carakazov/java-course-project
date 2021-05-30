<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" uri="mytag/show" %>
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
    <h1>Latest works</h1>
    <div>
        <c:forEach items="${list}" var="item">
            <div class="composition-block">
                Content: ${item.property.attributes.contentType} <br/>
                Access type: ${item.property.attributes.accessType} <br/>
                Authors:
                <ul>
                    <c:forEach items="${item.authors}" var="author">
                        <li>
                            <a href="/users/${author.login}">${author.personalInfo.name} ${author.personalInfo.surname}</a>
                        </li>
                    </c:forEach>
                </ul>
                <a href="/property/details/${item.propertyId}">Details</a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
