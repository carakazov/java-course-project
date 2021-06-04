<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
    <title>Account</title>
</head>
<body>
<header>
    <div><a class="logo" href="/">REEL DIR</a></div>
    <nav>
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
        </c:if>
    </div>
    <a href="${pageContext.request.contextPath}/property">Add composition</a>
</div>
</div>
</body>
</html>