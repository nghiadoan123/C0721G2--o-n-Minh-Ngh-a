<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/12/2021
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="/sand_witch" method="post">
      <input type="checkbox" name="condiment" value="Lettuce">
      <label >Lettuce</label>
      <input type="checkbox" name="condiment"  value="Tomato">
      <label >Tomato</label>
      <input type="checkbox" name="condiment"  value="Mustard">
      <label >Mustard</label>
      <input type="checkbox" name="condiment" value="Sprouts">
      <label >Sprouts</label>
      <button type="submit">Save</button>
    </form>

  </body>
</html>
