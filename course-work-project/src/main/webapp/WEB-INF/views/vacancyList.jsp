<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 06.06.2021
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>List for vacancies of asked profession</h1>
<div>
    <c:forEach items="${list}" var="item">
        <div class="composition-block">
            Employer: <a
                href="/users/${item.employerLogin}">${item.employer.surname} ${item.employer.name} ${item.employer.middleName}</a>
            <br>
            Salary: ${item.salary} <br>
            Start date ${item.startDate} <br>
            <a href="/vacancy/${item.vacancyId}">Details</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
