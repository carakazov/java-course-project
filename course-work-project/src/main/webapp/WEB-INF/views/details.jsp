<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="mytag/show" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
<header>
    <div><h1>REEL DIR</h1></div>
    <nav>
        <a href="/users/${session.login}">User</a>
        <a href="/logout">Logout</a>
    </nav>
</header>
<div class="center-body">
    <c:choose>
        <c:when test="${item.available}">
            <h1>${item.property.property.attributes.title}</h1>
            <mytag:showTag property="${item.property.property}"/>
            <div>
                <c:choose>
                    <c:when test="${item.requested}">
                        <label>Your request sent to owner. Please be patient</label>
                    </c:when>
                    <c:otherwise>
                        <label>Do you want to send buy request?</label>
                        <form:form method="post" action="/send" modelAttribute="requestDto">
                            <form:hidden path="sender"/>
                            <form:hidden path="propertyId"/>
                            <form:hidden path="sendingDate"/>
                            <button type="submit">Send request</button>
                        </form:form>
                    </c:otherwise>
                </c:choose>
            </div>
            <div>
                <a href="/review/${item.property.propertyId}">Write review</a>
            </div>
            <div>
                <a href="/list/${item.property.propertyId}">All reviews for this composition</a>
            </div>
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
