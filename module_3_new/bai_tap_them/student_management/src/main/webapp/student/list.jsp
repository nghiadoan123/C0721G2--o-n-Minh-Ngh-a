<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management</title>
    <style>
        table {
            border-collapse: collapse;
        }

    </style>
</head>
<body>
<h1>Student Management</h1>

<p><a href="/student?userAction=create">Create new Student</a></p>
<%-- cách 1 dùng nút bấm với form để sort--%>
<form action="/student?userAction=sort" method="post">
    <button type="submit">Sort by average</button>
</form>
<%--cách 2 dùng thẻ a khi dùng thẻ a thì mặc định là get--%>
<%--<p><a href="/users?userAction=sort">Sort by Name</a></p>--%>
<form action="/student?userAction=search" method="post">
    <table>
        <tr>
            <td><input type="text" name="search" id="country" placeholder="Enter name "></td>
            <td>
                <button type="submit">Search</button>
            </td>
        </tr>
    </table>
</form>
<h3>List of Users</h3>
<form method="post">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Average</th>
            <th>ID Class</th>
        </tr>
        <c:forEach var="student" items="${studentList}">
            <tr>
                <td>${student.getId()}</td>
                <td>${student.getName()}</td>
                <td>${student.getGender()}</td>
                <td>${student.getAge()}</td>
                <td>${student.getAverage()}</td>
                <td>
                    <c:forEach var="studentClass" items="${studentClassList}">
                        <c:if test="${student.getIdClass() == studentClass.getIdClass()}">
                            ${studentClass.getClassName()}
                        </c:if>
<%--                        <c:choose>--%>
<%--                            <c:when test="${student.getIdClass() == studentClass.getIdClass()}">--%>
<%--                                ${studentClass.getClassName()}--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                ${"null"}--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>
                    </c:forEach>
                </td>
                    <%--                <td>${student.getIdClass()}</td>--%>
                <td>
                    <a href="/student?userAction=edit&id=${student.getId()}"
                       onclick="return confirm('Do you want to edit ${student.getName()} ?')">Edit</a>
                    <a href="/student?userAction=delete&id=${student.getId()}"
                       onclick="return confirm('Do you want to delete ${student.getName()} ?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
