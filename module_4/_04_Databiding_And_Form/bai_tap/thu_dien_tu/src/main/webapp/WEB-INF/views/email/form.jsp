<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/15/2021
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h3>Language</h3>
<form:form  method="post" modelAttribute="Email" >
    <label for="language"><strong> Choose language:</strong></label>
    <form:select path="language" id="language">
        <form:options items="${language}"></form:options>
    </form:select>

    <br><br>
    <label for="numberPage1"> <strong>Page Size : </strong> Show emails per page </label>
    <form:select path="paperSize" id="numberPage1">
        <form:options items="${pageSize}"></form:options>
    </form:select>
    <br><br>
    <h4 style="display: inline">Spams filter:</h4>
    <label >Enable spams filter</label>
<%--    <form:select path="spamFilter" id="emailsSpam">--%>
<%--        <form:options items="${spamsFilter}"></form:options>--%>
<%--    </form:select>--%>
    <form:checkbox path="spamFilter"></form:checkbox>
    <br><br>
    <h4 >Signature: </h4>
    <form:textarea path="signature" value="${signature}"></form:textarea>
    <br>
    <br>
    <button type="submit" onclick="return confirm('Do you want to save?')">Save</button>
    <button onclick="location.href='/'" type="button">Cancel</button>
</form:form>
</body>
</html>

