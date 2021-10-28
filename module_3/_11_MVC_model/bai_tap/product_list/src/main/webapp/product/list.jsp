<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/products?actionUser=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Manage</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="/products?actionUser=view&id=${product.getProductId()}">${product.getProductName()}</a></td>
            <td>${product.getProductPrice()}</td>
            <td>${product.getProductDescription()}</td>
            <td>${product.getProductManage()}</td>
            <td><a href="/products?actionUser=edit&id=${product.getProductId()}">edit</a></td>
            <td><a href="/products?actionUser=delete&id=${product.getProductId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
