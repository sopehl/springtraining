<%--
  Created by IntelliJ IDEA.
  User: semih
  Date: 05.05.2015
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DONE</title>
</head>
<body>
<p>${done}</p>
<p>user name: ${name}</p>

<form action="/do/done" method="post">
    Name:<input type="text" name="name">
    <input type="submit" value="Save">
</form>

<p>Saved personel : ${formName}</p>
</body>
</html>
