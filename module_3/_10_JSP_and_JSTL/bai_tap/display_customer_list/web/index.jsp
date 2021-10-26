<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/10/2021
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Customer List</title>
    <style>
      *{
        box-sizing: border-box;
      }

      .col-1 {width: 8.33%}
      .col-2 {width: 16.66%}
      .col-3 {width: 25%}
      .col-4 {width: 33.33%}
      .col-5 {width: 41.66%}
      .col-6 {width: 50%}
      .col-7 {width: 58.33%}
      .col-8 {width: 66.66%}
      .col-9 {width: 75%}
      .col-10 {width: 83.33%}
      .col-11 {width: 91.66%}
      .col-12 {width: 100%}

      [class*=col-] {
        float: left;
        padding: 5px;
      }

      .row::after {
        clear: both;
        display: block;
        content: "";
      }

      .header-title {
        text-align: center;
      }

    </style>
  </head>
  <body>
  <form >
    <div class="row">
      <div class="col-12">
        <h1 class="header-title">Danh Sách Khách Hàng</h1>
      </div>
    </div>

    <div class="row">
      <div class="col-3">
        <h1 >Tên</h1>
      </div>

      <div class="col-3">
        <h1 >Ngày Sinh</h1>
      </div>

      <div class="col-3">
        <h1 >Địa chỉ</h1>
      </div>

      <div class="col-3">
        <h1>Ảnh</h1>
      </div>
    </div>
    <hr>

    <div class="row">
      <div class="col-3">
        <p >Mai Văn Hoàn</p>
      </div>

      <div class="col-3">
        <p >1983-08-20</p>
      </div>

      <div class="col-3">
        <p >Hà Nội</p>
      </div>

      <div class="col-3">
        <img src="//anhdaidien.jpg" width="30px" height="30px" alt="">
      </div>
    </div>
    <hr>

  </form>
  </body>
</html>
