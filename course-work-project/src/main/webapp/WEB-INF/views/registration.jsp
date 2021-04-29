<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div>
    <label>Input your data here:</label>
</div>
<div>
    <form:form method="post" action="${pageContext.request.contextPath}/createUser"
               modelAttribute="registrationDto">

        <div>
            <label>Login: </label>
            <label>
                <form:input type="text" path="identityInfoDto.login"/>
                <form:errors path="identityInfoDto.login"/>
            </label>
        </div>
        <div>
            <label>Password: </label>
            <label>
                <form:input type="password" path="identityInfoDto.password"/>
                <form:errors path="identityInfoDto.password"/>
            </label>
        </div>
        <div>
            <label>Name: </label>
            <label>
                <form:input type="text" path="personalInfoDto.name"/>
                <form:errors path="personalInfoDto.name"/>
            </label>
        </div>
        <div>
            <label>Surname: </label>
            <label>
                <form:input type="text" path="personalInfoDto.surname"/>
                <form:errors path="personalInfoDto.surname"/>
            </label>
        </div>
        <div>
            <label>Middle name:</label>
            <label>
                <form:input type="text" path="personalInfoDto.middleName"/>
                <form:errors path="personalInfoDto.middleName"/>
            </label>
            <small>Optional</small>
        </div>
        <div>
            <label>E-mail:</label>
            <label>
                <form:input type="email" path="personalInfoDto.email"/>
                <form:errors path="personalInfoDto.email"/>
            </label>
        </div>
        <div>
            <label>Who are you?</label>
            <p>
                <form:checkbox path="roles" value="user"/> Simple user.
            </p>
            <p>
                <form:checkbox path="roles" value="author"/> Author.
            </p>
            <p>
                <form:checkbox path="roles" value="owner"/> Product owner.
            </p>
            <form:errors path="roles"/>
        </div>
        <div>
            <lavel>Are you looking for work?</lavel>
            <form:checkbox path="lookingForWork"/>
            <form:errors path="lookingForWork"/>
        </div>
        <button type="submit">Registration</button>
    </form:form>
</div>
</body>
</html>