
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${product_edit.getProductName()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${product_edit.getProductPrice()}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="description" value="${product_edit.getProductDescription()}"></td>
            </tr>
            <tr>
                <td>Manage: </td>
                <td><input type="text" name="manage" id="manage" value="${product_edit.getProductManage()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
