<%--
  Created by IntelliJ IDEA.
  User: semih
  Date: 04.05.2015
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RequestBody</title>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript">

        JSONTest = function() {

            $.ajax({
                url: "/request",
                type: "get",
                data: {
                    name: "Okan",
                    lastname: "Pehlivan",
                    age:22 },
                dataType: "json",
                contentType:"application/json; charset=utf-8",
                async: false,
                cache: false,
                processData:false
            });
        };

    </script>
</head>
<body>
    <p>${requestKey}</p>

    <h1>My jQuery JSON Web Page</h1>

    <div id="resultDivContainer"></div>

    <button type="button" onclick="JSONTest()">JSON</button>

    <p>${name}</p>
    <p>${lastname}</p>
    <p>${age}</p>
</body>
</html>
