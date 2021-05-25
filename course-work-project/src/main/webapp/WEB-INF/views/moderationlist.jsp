<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" uri="mytag/show" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 24.05.2021
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moderator page</title>
</head>
<body>
<h1>New compositions list</h1>
<c:forEach items="${items}" var="item">
    <mytag:showTag property="${item.property}"/>
</c:forEach>
</body>
</html>
