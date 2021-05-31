<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 31.05.2021
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscribe page</title>
    <script>
        <%@include file="css/skeleton.css"%>
    </script>
</head>
<body>
<div>
    <h1>Subscribe form</h1>
    <form:form modelAttribute="subscribeDto" method="post" action="/subscribe">
        <Label>You are going to subscribe to ${subscribeDto.bloggerLogin}. Are you sure?</Label>
        <form:hidden path="bloggerLogin"/>
        <form:hidden path="subscriberLogin"/>
        <form:hidden path="propertyId"/>
        <div>
            <button type="submit" class="button">Subscribe</button>
        </div>
    </form:form>
</div>
</body>
</html>
