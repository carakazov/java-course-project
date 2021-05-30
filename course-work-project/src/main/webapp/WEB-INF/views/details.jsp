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
</head>
<body>
<div>
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
                    buy it
                </c:if>
                <c:if test="${item.property.property.attributes.accessType == AccessTypeEnum.subscription}">
                    subscribe to this product owner
                </c:if>
            </label>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
