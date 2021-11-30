
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getProductName() }</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["product"]. getProductPrice()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${requestScope["product"].getProductDescription() }</td>
    </tr>
    <tr>
        <td>Manage: </td>
        <td>${requestScope["product"].getProductManage()}</td>
    </tr>
</table>
</body>
</html>
