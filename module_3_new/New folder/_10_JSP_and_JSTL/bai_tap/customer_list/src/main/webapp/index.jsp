<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Customer List</title>
      <style>
          .header {
              text-align: center;
          }
      </style>

  </head>
  <body>
      <h2 class="header">Student List</h2>
      <table class="table">

          <thead>
          <tr>
              <th scope="col">Tên</th>
              <th scope="col">Ngày Sinh</th>
              <th scope="col">Địa Chỉ</th>
              <th scope="col">Ảnh</th>
          </tr>
          </thead>

          <tbody>
    <c:forEach var="customerObj" items="${CustomerListServlet}" varStatus="loop">
        <tr>
            <td><c:out value="${customerObj.name}"/></td>
            <td><c:out value="${customerObj.dateOfBirth}"/></td>
            <td><c:out value="${customerObj.address}"/></td>
            <td><img width="20px" height="20px" src="<c:out value="${customerObj.image}"/>" alt=""></td>
        </tr>
    </c:forEach>
          </tbody>

      </table>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
              integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
              crossorigin="anonymous">

      </script>
  </body>
</html>
