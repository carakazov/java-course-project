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
  </head>
  <body>
  <h1>Welcome!</h1>
  <form>
    <div class="mb-3">
      <label class="form-label">Login: </label>
      <label>
        <input type="text" class="form-control"/>
      </label>
    </div>
    <div class="mb-3">
      <label class="form-label">Password: </label>
      <label>
        <input type="text" class="form-control">
      </label>
    </div>
    <label>
      <button type="submit" class="btn btn-primary">Submit</button>
    </label>
  </form>

  <div>
    <label>Not a user? <a href="${pageContext.request.contextPath}/registration">Become now!</a> </label>
  </div>
  </body>
</html>
