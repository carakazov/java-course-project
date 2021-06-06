<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 07.06.2021
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>List of users who looking for work</h1>
<div>
    <c:forEach items="${list}" var="item">
        <div class="composition-block">
            <a href="/users/${item.login}">${item.personalInfo.name} ${item.personalInfo.surname} ${item.personalInfo.middleName}</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
