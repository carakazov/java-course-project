<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 31.05.2021
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy Form</title>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
</head>
<body>
<h1>Best banking service in the world</h1>
<form:form action="/property/buy" method="post" modelAttribute="buyPropertyDto">
    <div>
        Вы собираетесь заплатить:
        <label>Price: ${formData.price}</label>
    </div>
    <form:hidden path="login"/>
    <form:hidden path="propertyId"/>
    <div>
        <form:checkbox path="forever"/> Buy forever?
    </div>
    <div>
        <button type="submit" class="button">Buy</button>
    </div>
</form:form>
</body>
</html>
