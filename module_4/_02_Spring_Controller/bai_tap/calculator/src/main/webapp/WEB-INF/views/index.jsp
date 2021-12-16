<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2021
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="get">

    <div>
        <input type="text" name="numberOne">
        <input type="text" name="numberTwo">
    </div>
    <button type="submit" name="name" value="+">Addition(+)</button>
    <button type="submit" name="name" value="-">Subtraction(-)</button>
    <button type="submit" name="name" value="*">Multiplication(*)</button>
    <button type="submit" name="name" value="/">Division(/)</button>
    <h2>${result} </h2>
</form>
</body>
</html>
