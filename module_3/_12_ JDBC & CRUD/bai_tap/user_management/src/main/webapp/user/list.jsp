<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
    <style>
        table{
            border-collapse: collapse;
        }

    </style>
</head>
<body>
<h1>User Management</h1>
<p><a href="/users?userAction=create">Create new User</a></p>
<p><a href="/users?userAction=sort">Sort by Name</a></p>
<form action="/users?userAction=search" method="post">
    <table>
        <tr>
            <td><input type="text" name="country" id="country" placeholder="Enter country "></td>
            <td><button type="submit">Search</button></td>
        </tr>
    </table>
</form>
<h3>List of Users</h3>
<form method="post">
    <table border="1" >
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
                <td>
                    <a href="/users?userAction=edit&id=${user.getId()}">Edit</a>
                    <a href="/users?userAction=delete&id=${user.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
