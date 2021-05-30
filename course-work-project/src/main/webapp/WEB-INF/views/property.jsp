<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: carak
  Date: 04.05.2021
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
</head>
<body>
<header>
    <div><h1>REEL DIR</h1></div>
    <nav>
        <a href="/users/${session.login}">User</a>
        <a href="/logout">Logout</a>
    </nav>
</header>
<form:form action="/property/add" method="post"
           modelAttribute="property" enctype="multipart/form-data">
    <div>
        <label>Title: </label>
        <form:input path="intellectualPropertyDto.attributes.title"/>
        <form:errors path="intellectualPropertyDto.attributes.title"/>
    </div>
    <div>
        <label>Choose content type: </label>
        <form:radiobutton path="intellectualPropertyDto.attributes.accessType" value="free"/> Free
        <form:radiobutton path="intellectualPropertyDto.attributes.accessType" value="subscription"/> Subscription
        <form:radiobutton path="intellectualPropertyDto.attributes.accessType" value="payable"/> Payable
        <form:errors path="intellectualPropertyDto.attributes.accessType"/>
        <label>If content isn't free input price</label>
        <form:input path="intellectualPropertyDto.attributes.price"/>
    </div>
    <div>
        <label>Choose content type</label>
        <form:radiobutton path="intellectualPropertyDto.attributes.contentType" value="text"/> Text
        <form:radiobutton path="intellectualPropertyDto.attributes.contentType" value="picture"/> Photo
        <form:radiobutton path="intellectualPropertyDto.attributes.contentType" value="video"/> Movie
        <form:radiobutton path="intellectualPropertyDto.attributes.contentType" value="audio"/> Music
        <form:errors path="intellectualPropertyDto.attributes.contentType"/>
    </div>
    <div>
        <label>Choose genres: </label>
        <form:checkboxes path="intellectualPropertyDto.attributes.genres" items="${genres}"/>
        <form:errors path="intellectualPropertyDto.attributes.genres"/>
    </div>

    <div>
        <label>Load your content here:</label>
        <input type="file" name="file">
    </div>

    <div>
        <button type="submit" class="button">Add</button>
    </div>

</form:form>
</body>
</html>
