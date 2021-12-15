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
        <legend>Information </legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id" id="id" value="${edit.id}" readonly></td>
            </tr>
            <tr>
                <td>benh an:</td>
                <td>
                    <input type="text" name="benhan" id="name" value="${edit.idBenhAn.getId()}">
                    <span style="color: red"> ${messageName}</span>
                </td>
            </tr>

            <tr>
                <td>benh nhan:</td>
                <td>
                    <input type="text" name="benhnhan" id="country" value="${edit.idBenhNhan.getId()}">
                    <span style="color: red"> ${messageAge}</span>
                </td>
            </tr>
            <tr>
                <td>ngay nhap vien:</td>
                <td>
                    <input type="text" name="ngaynhapvien"  value="${edit.ngayNhapVien}">
                    <span style="color: red"> ${messageAverage}</span>

                </td>
            </tr>
            <tr>
                <td>ngay ra vien:</td>
                <td>
                    <input type="text" name="ngayravien"  value="${edit.ngayRaVien}">
                    <span style="color: red"> ${errormessage}</span>
                </td>

            </tr>
            <tr>
                <td>ly do:</td>
                <td>
                    <input type="text" name="lydo"  value="${edit.lyDo}">
                    <span style="color: red"> ${errormessage}</span>
                </td>

            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Save</button></td>
            </tr>
            <tr>
                <td></td>
               <button><a href="/danhsachbenhnhan"
                          onclick="return confirm('Do you want to back' )">back</a></button>
            </tr>
        </table>

    </fieldset>
</form>
<div><a href="/benhAn">Back to List</a></div>

</body>
</html>

