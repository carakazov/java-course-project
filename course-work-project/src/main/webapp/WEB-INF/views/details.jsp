<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="mytag/show" %>
<%@page import="project.model.AccessTypeEnum" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 30.05.2021
  Time: 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
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
    <c:choose>
        <c:when test="${item.available}">
            <h1>${item.property.property.attributes.title}</h1>
            <mytag:showTag property="${item.property.property}"/>
        </c:when>
        <c:otherwise>
            <label>
                Sorry, this content is no acceptable for you now. <br/>
                To see it you have to:
                <c:if test="${item.property.property.attributes.accessType == AccessTypeEnum.payable}">
                    <a href="${pageContext.request.contextPath}/property/buy?price=${item.property.property.attributes.price}
                    &propertyId=${item.property.propertyId}&login=${session}">buy it</a>
                </c:if>
                <c:if test="${item.property.property.attributes.accessType == AccessTypeEnum.subscription}">
                    <a href="/property/subscribe?propertyId=${item.property.propertyId}&subscriberLogin=${session}">
                        subscribe to this product owner</a>
                </c:if>
            </label>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
