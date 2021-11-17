
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${product_delete.getProductName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${product_delete.getProductPrice()}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${product_delete.getProductDescription()}</td>
            </tr>
            <tr>
                <td>Manage: </td>
                <td>${product_delete.getProductManage()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>
