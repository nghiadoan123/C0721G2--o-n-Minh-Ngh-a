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
                <td><input type="text" name="id" id="id" value="${edit.getId()}" readonly></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" name="name" id="name" value="${edit.getName()}">
                    <span style="color: red"> ${messageName}</span>
                </td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <c:set var = "gender" scope = "session" value = "${edit.getGender()}"/>
                    <c:if test='${"gender" == null or "gender"!= null}'>
                        <select name="gender">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </c:if>
                </td>
<%--                <td><input type="text" name="gender" id="email" value="${edit.getGender()}" ></td>--%>
            </tr>
            <tr>
                <td>Age:</td>
                <td>
                    <input type="text" name="age" id="country" value="${edit.getAge()}">
                    <span style="color: red"> ${messageAge}</span>
                </td>
            </tr>
            <tr>
                <td>Average:</td>
                <td>
                    <input type="text" name="average"  value="${edit.getAverage()}">
                    <span style="color: red"> ${messageAverage}</span>

                </td>
            </tr>
            <tr>
                <td>ID Class:</td>
                <td>
                    <input type="text" name="classId"  value="${edit.getIdClass()}">
                    <span style="color: red"> ${errormessage}</span>
                </td>

            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Save</button></td>
            </tr>
        </table>
    </fieldset>
</form>
<div><a href="/student">Back to List of Student</a></div>

</body>
</html>
