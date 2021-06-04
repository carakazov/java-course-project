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
        label{
            display: inline;
        }
        .margin{
            margin-bottom: 5px;
        }
        .cost{
            color: #555555;
            font-weight: normal;
        }
    </style>
</head>
<body>
<header>
    <div><a class="logo" href="/">REEL DIR</a></div>
    <nav>
        <a href="/users/${session.login}">Account</a>
        <a href="/logout">Logout</a>
    </nav>
</header>
<div class="center-body">

        <form:form action="/property/add" method="post"
           modelAttribute="property" enctype="multipart/form-data">
    <div class="margin">
        <label>Title: </label>
        <form:input path="intellectualPropertyDto.attributes.title"/>
        <form:errors path="intellectualPropertyDto.attributes.title"/>
    </div>
    <div class="margin">
        <label>Choose content type: </label>
        <form:radiobutton path="intellectualPropertyDto.attributes.accessType" value="free"/>
        <span>Free</span>
        <form:radiobutton path="intellectualPropertyDto.attributes.accessType" value="subscription"/>
        <span>Subscription</span>
        <form:radiobutton path="intellectualPropertyDto.attributes.accessType" value="payable"/>
        <span>Payable</span>
        <form:errors path="intellectualPropertyDto.attributes.accessType"/>
    </div>
            <div class="margin">
                <label class="cost">If content isn't free input price:</label>
                <form:input path="intellectualPropertyDto.attributes.price"/>
            </div>
    <div class="margin">
        <label>Choose content type</label>
        <form:radiobutton path="intellectualPropertyDto.attributes.contentType" value="text"/>
        <span>Text</span>
        <form:radiobutton path="intellectualPropertyDto.attributes.contentType" value="picture"/>
        <span>Photo</span>
        <form:radiobutton path="intellectualPropertyDto.attributes.contentType" value="video"/>
        <span>Movie</span>
        <form:radiobutton path="intellectualPropertyDto.attributes.contentType" value="audio"/>
        <span>Music</span>
        <form:errors path="intellectualPropertyDto.attributes.contentType"/>
    </div>
    <div class="margin">
        <label>Choose genres: </label>
        <form:checkboxes cssStyle="font-weight: normal" path="intellectualPropertyDto.attributes.genres" items="${genres}"/>
        <form:errors path="intellectualPropertyDto.attributes.genres"/>
    </div>

    <div>
        <label>Load your content here:</label>
        <input type="file" name="file">
    </div>

    <div>
        <button type="submit" class="button-primary">Add</button>
    </div>

    </form:form>
</div>
</body>
</html>
