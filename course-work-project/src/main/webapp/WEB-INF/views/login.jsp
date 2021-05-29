<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 20.04.2021
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reel Deer</title>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
</head>
<body>
<h1 class="h1-center">Welcome!</h1>
<form action="${pageContext.request.contextPath}/login" method="post" class="from-center"/>
<div>
    <label>
        <input type="text" name="login" placeholder="Login"/>
    </label>
</div>
<div>
    <label>
        <input type="password" name="password" placeholder="Password"/>
    </label>
</div>
<div>
  <label>
    <button type="submit" class="button-primary">Submit</button>
  </label>
</div>
<span class="error-message">${error}</span>
<br>
<label class="login-label-link">Not a user? <a href="${pageContext.request.contextPath}/registration">Become now!</a>
</label>
</form>
</body>
</html>
