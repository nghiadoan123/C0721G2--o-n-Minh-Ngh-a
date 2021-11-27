<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/11/2021
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<h2>Product</h2>
<form action="/product" method="post">
  <div>
    <input type="text" name="txtSearch" placeholder="Enter product description: ">
  </div>

  <div>
    <input type="text" name="listPrice" placeholder="Enter price">
  </div>

  <div>
    <input type="text" name="discountPercent" placeholder="Enter discount person">
  </div>

  <input type="submit" id="submit" value="result">
</form>

</body>
</html>
