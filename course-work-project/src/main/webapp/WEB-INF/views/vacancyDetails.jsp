<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 06.06.2021
  Time: 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <style>
        <%@include file="css/skeleton.css" %>
    </style>
</head>
<body>
<div>
    <div class="composition-block">
        Employer: <a
            href="/users/${item.item.employerLogin}">${item.item.employer.surname} ${item.item.employer.name} ${item.item.employer.middleName}</a>
        <br>
        Employer email: ${item.item.employer.email} <br>
        Salary: ${item.item.salary} <br>
        Start date: ${item.item.startDate} <br>
        Description: ${item.description} <br>
    </div>
</div>
</body>
</html>
