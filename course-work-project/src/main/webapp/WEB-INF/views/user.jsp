<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytags" uri="mytag/show" %>
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
<div class="user-body">
    <div class="user-left">
        <div style="display: block">
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

            </div>
        </div>
    </div>

    <div class="user-right">
        <div style="display: block">
            <a href="${pageContext.request.contextPath}/property">Add composition</a>
            <a href="${pageContext.request.contextPath}/requestList">Show all received requests</a>
            <a href="${pageContext.request.contextPath}/vacancy">Add new vacancy</a>
            <a href="${pageContext.request.contextPath}/professions">Looking for job?</a>
            <a href="${pageContext.request.contextPath}/work">Search for employees</a>
        </div>
    </div>
    <div class="user-left">
        <div style="display: block">
            <c:if test="${user.login == session.login}">
                <label>Add description</label>
                <form:form action="/description" method="post"
                           modelAttribute="user" cssStyle="display: flex">
                    <form:hidden path="login"/>
                    <form:textarea path="description" cssClass="textarea"/>
                    <button type="submit">Add</button>
                </form:form>

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