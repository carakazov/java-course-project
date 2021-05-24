<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file="css/skeleton.css"%>
    </style>
    <title>Registration</title>
</head>
<body>
<div>
    <h1>Registration</h1>
    <label>Input your data here:</label>
</div>
<div>
    <form:form method="post" action="${pageContext.request.contextPath}/createUser"
               modelAttribute="registrationDto">
        <div>
            <label>
                Login:
            </label>
            <form:input type="text" path="identityInfoDto.login" cssClass="my-input-form"/>
            <form:errors path="identityInfoDto.login"/>
        </div>
        <div>
            <label>
                Password:
            </label>
            <form:input type="password" path="identityInfoDto.password"/>
            <form:errors path="identityInfoDto.password"/>
        </div>
        <div>
            <label>
                Name:
            </label>
            <form:input type="text" path="personalInfoDto.name"/>
                <form:errors path="personalInfoDto.name"/>
        </div>
        <div>
            <label>
                Surname:
            </label>
            <form:input type="text" path="personalInfoDto.surname"/>
                <form:errors path="personalInfoDto.surname"/>
        </div>
        <div>
            <label>
                Middle name:
            </label>
            <form:input type="text" path="personalInfoDto.middleName"/>
                <form:errors path="personalInfoDto.middleName"/>
            <small>Optional</small>
        </div>
        <div>
            <label>
                E-mail:
            </label>
            <form:input type="email" path="personalInfoDto.email"/>
            <form:errors path="personalInfoDto.email"/>
        </div>
        <div>
            <label>
                Who are you?
            </label>
            <form:checkbox path="roles" value="user"/> Simple user.
            <form:checkbox path="roles" value="author"/> Author.
            <form:checkbox path="roles" value="owner"/> Product owner.
            <form:errors path="roles"/>
        </div>
        <div>
            <label>Are you looking for work?</label>
            <form:checkbox path="lookingForWork"/>
        </div>
        <button type="submit" class="button-primary">Registration</button>
    </form:form>
</div>
</body>
</html>