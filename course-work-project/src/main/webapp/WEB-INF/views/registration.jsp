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
    <form method="post" action="/createUser">
        <div>
            <label>Login: </label>
            <label>
                <input type="text" name="${registrationDto.identityInfoDto.login}">
            </label>
        </div>
        <div>
            <label>Password: </label>
            <label>
                <input type="password" name="${registrationDto.identityInfoDto.password}">
            </label>
        </div>
        <div>
            <label>Name: </label>
            <label>
                <input type="text" name="${registrationDto.personalInfoDto.name}">
            </label>
        </div>
        <div>
            <label>Surname: </label>
            <label>
                <input type="text" name="${registrationDto.personalInfoDto.surname}">
            </label>
        </div>
        <div>
            <label>Middle name:</label>
            <label>
                <input type="text" name="${registrationDto.personalInfoDto.middleName}">
            </label>
            <small>Optional</small>
        </div>
        <div>
            <label>E-mail:</label>
            <label>
                <input type="email" name="${registrationDto.personalInfoDto.email}">
            </label>
        </div>
        <button type="submit">Registration</button>
    </form>
</div>
</body>
</html>