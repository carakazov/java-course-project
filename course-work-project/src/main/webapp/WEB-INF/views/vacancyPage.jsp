<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 06.06.2021
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vacancy</title>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
</head>
<body>
<h1>Here you can add new vacancy</h1>
<div class="center-body">
    <form:form action="/vacancy" modelAttribute="vacancy" method="post">
        <form:hidden path="employerLogin"/>
        Description: <form:input path="description"/> <br>
        Salary: <form:input path="salary"/> <br>
        Work experience <form:input path="experience"/> <br>
        Profession:
        <form:select path="profession">
            <form:options items="${professionList}"/>
        </form:select>
        <div>
            <button type="submit">Create</button>
        </div>
    </form:form>
</div>
</body>
</html>
