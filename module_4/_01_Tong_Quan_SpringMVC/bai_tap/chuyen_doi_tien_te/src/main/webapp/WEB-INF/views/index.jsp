<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/12/2021
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form method="post" action="">
      <p>Input USD:</p>
      <div>
        <input type="text" name="usd" placeholder="input usd">
      </div>
      <p>Input exchange rate (USD/VND): </p>
      <div>
        <input type="text" name="exchangeRate" placeholder="input exchange rate ">
      </div>
      <br>
      <div>
        <button type="submit" value="result"> Result</button>
      </div>

    </form>
    <div>
      <c:if test="${exchangeResult != null}">
        <div>Result is <p style="color: red"> ${exchangeResult}</p> </div>
      </c:if>
    </div>

  </body>
</html>
