<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 06.06.2021
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Professions</title>
    <style>
        <%@include file="css/skeleton.css" %>
    </style>
</head>
<body>
<h1>Here you can find all professions you can find vacancies for</h1>
<div>
    <c:forEach items="${list}" var="item">
        <div class="composition-block">
            <a href="${pageContext.request.contextPath}/vacancy/find?profession=${item}">${item}</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
