<%--
  Created by IntelliJ IDEA.
  User: semih
  Date: 10.05.2015
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/j_spring_security_check" method="POST">
    <label for="username">Kullanici
        ismi:</label>
    <input id="username" name="j_username"
           type="text" />
    <label for="password">sifre:</label>
    <input id="password" name="j_password"
           type="password" />
    <input type="submit" value="Login" />
</form>
</body>
</html>
