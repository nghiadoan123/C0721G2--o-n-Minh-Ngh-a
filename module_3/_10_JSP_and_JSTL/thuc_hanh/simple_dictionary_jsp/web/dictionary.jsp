<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/10/2021
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta>
    <title>Simple Dictionary</title>
</head>
<body>
    <%!
        Map<String,String> dictionary = new HashMap<>();
    %>

    <%
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    %>

    <%
    String search = request.getParameter("search");

    String result = dictionary.get(search);
    if (result != null) {
    out.println("Word: " + search);
    out.println("Result: " + result);
    } else {
    out.println("Not found");
    }

    %>

</body>
</html>
