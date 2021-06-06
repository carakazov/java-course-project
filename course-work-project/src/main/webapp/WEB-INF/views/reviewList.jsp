<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 02.06.2021
  Time: 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All reviews</title>
</head>
<body>
<h1>All reviews for this composition</h1>
<c:forEach items="${list}" var="item">
    <div class="composition-block">
        Author: <a
            href="/users/${item.authorLogin}">${item.author.surname} ${item.author.name} ${item.author.middleName}</a><br>
        Score: ${item.score}
    </div>
    <div>
        <a href="/review/details/${item.reviewId}">Read full review</a>
    </div>
</c:forEach>
</body>
</html>
