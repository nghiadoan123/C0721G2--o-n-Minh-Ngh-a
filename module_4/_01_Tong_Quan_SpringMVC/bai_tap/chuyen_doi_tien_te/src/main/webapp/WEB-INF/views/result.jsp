<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/12/2021
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <c:if test="${exchangeResult != null}">
        <div>Result is <p style="color: red"> ${exchangeResult}</p> </div>
    </c:if>
</div>
</body>
</html>
