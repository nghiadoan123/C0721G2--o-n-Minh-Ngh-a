<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management</title>
</head>
<body>
<h1>Student Management</h1>
<h3>Edit Student</h3>

<form method="post">
    <fieldset>
        <legend>Information Student</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id" placeholder="Enter your id"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" name="name" id="name" placeholder="Enter your Name">
                    <span style="color: red"> ${messageName}</span>
                </td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <select name="gender">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </td>
                <%--                <td><input type="text" name="gender" id="email" value="${edit.getGender()}" ></td>--%>
            </tr>
            <tr>
                <td>Age:</td>
                <td>
                    <input type="text" name="age" id="country" placeholder="Enter your age">
                    <span style="color: red"> ${messageAge}</span>
                </td>
            </tr>
            <tr>
                <td>Average:</td>
                <td>
                    <input type="text" name="average" placeholder="Enter your average">
                    <span style="color: red"> ${messageAverage}</span>
                </td>
            </tr>
            <tr>
                <td>ID Class:</td>
                <td>
                    <input type="text" name="idClass" placeholder="Enter your id class">
                    <span style="color: red"> ${errormessage}</span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Create</button></td>
            </tr>
        </table>
    </fieldset>
</form>
<div><a href="/benhAn">Back to List of Student</a></div>

</body>
</html>