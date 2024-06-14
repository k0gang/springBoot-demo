<%--
  Created by IntelliJ IDEA.
  User: TJ
  Date: 2024-06-14
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/user/loginAction" id="loginForm">
    <!-- 입력 필드 예시 -->
    <label for="userName">Username:</label>
    <input type="text" id="userName" name="userName"><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
