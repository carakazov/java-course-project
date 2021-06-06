<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytags" uri="mytag/show" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
    <title>Registration</title>
</head>
<body>
<header>
    <div><h1>REEL DIR</h1></div>
    <nav>
        <a href="/users/${session.login}">User</a>
        <a href="/logout">Logout</a>
    </nav>
</header>
<div class="center-body">
<div>
    <label>${user.personalInfo.name}, ${user.personalInfo.surname}, ${user.personalInfo.middleName}</label>
</div>
<div>
    <label>Contacts: </label>
    Email: ${user.personalInfo.email}
</div>
<div>
    <label>About myself</label>
    <div>
        <c:choose>
            <c:when test="${user.description != null}">
                <div class="description-block">
                        ${user.description}
                </div>
            </c:when>
            <c:otherwise>
                <label>User still didnt't add any description</label>
            </c:otherwise>
        </c:choose>
    </div>
    <div>
        <c:if test="${user.login == session.login}">
            <p>Add description</p>
            <form:form action="/description" method="post"
                       modelAttribute="user">
                <form:hidden path="login"/>
                <form:textarea path="description"/>
                <button type="submit">Add</button>
            </form:form>
            <a href="${pageContext.request.contextPath}/requestList">Show all received requests</a> <br>
            <a href="${pageContext.request.contextPath}/property">Add composition</a> <br>
            <a href="${pageContext.request.contextPath}/vacancy">Add new vacancy</a> <br>
            <a href="${pageContext.request.contextPath}/professions">Looking for job?</a> <br>
            <a href="${pageContext.request.contextPath}/work">Search for employees</a>
            <label>Add portfolio</label>
            <form:form action="/portfolio/add" enctype="multipart/form-data" method="post">
                <div>
                    <input type="file" name="portfolio">
                </div>
                <div>
                    <button type="submit" class="button">Add</button>
                </div>
            </form:form>
        </c:if>
        <c:if test="${user.portfolio != null}">
            <mytags:portfolio portfolioOwner="${user}"/>
        </c:if>

    </div>
</div>
</div>
</body>
</html>