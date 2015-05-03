<%--
  Created by IntelliJ IDEA.
  User: semih
  Date: 02.05.2015
  Time: 03:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>First Spring MVC</title>
  </head>
  <body>
        <%--Burada bir yer tutucu bulunmaktadır(placeholder) gösterim şekli ise ${} şeklindedir. Spring eğer bir placeholder ile karşılaşırsa
            bunun ModelMap objesinin bir key değeri olduğunu anlamaktadır. Bu sayede spring ve jsp sayfaların içeriklerini dinamik olarak değiştirirler--%>
        <h1>${title}</h1>

        <a href="form.jsp">Formu Doldur</a>

  </body>
</html>
