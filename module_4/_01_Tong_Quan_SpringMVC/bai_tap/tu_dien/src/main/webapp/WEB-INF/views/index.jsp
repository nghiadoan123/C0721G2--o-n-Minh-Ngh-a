<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/12/2021
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/dictionary">
    <div>
      Input your world:
    </div>
    <div>
      <input type="text" name="search">
    </div>
    <div>
      <button type="submit" value="result">Result</button>
    </div>
    <div>
      <c:if test="${result != null}">
        <div>Result is <p style="color: red"> ${result}</p> </div>
      </c:if>
    </div>
  </form>
  </body>
</html>
