<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2021
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/create" method="post">
    <p>id: </p>
    <input name="id">
    <p>name: </p>
    <input name="name">
    <p>email</p>
    <input type="text" name="email">
    <p>address</p>
    <input name="address">
    <button type="submit">Create</button>
</form>
</body>
</html>
