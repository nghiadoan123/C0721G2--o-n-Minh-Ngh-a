<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2021
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <caption>Customers</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <c:out value="${customer.id}"/>
            </td>
            <td>
                <c:out value="${customer.name}"/>
            </td>
            <td>
                <c:out value="${customer.email}"/>
            </td>
            <td>
                <c:out value="${customer.address}"/>
            </td>
        </tr>
    </tbody>

</body>
</html>
