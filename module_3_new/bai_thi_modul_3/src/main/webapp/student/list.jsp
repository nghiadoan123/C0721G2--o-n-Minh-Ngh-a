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
<h1></h1>

<p><a href="/danhsachbenhnhan?userAction=create">tao moi benh an</a></p>
<%-- cách 1 dùng nút bấm với form để sort--%>
<%--<form action="/danhsachbenhan?userAction=sort" method="post">--%>
<%--    <button type="submit">Sort by average</button>--%>
<%--</form>--%>
<%--cách 2 dùng thẻ a khi dùng thẻ a thì mặc định là get--%>
<%--<p><a href="/users?userAction=sort">Sort by Name</a></p>--%>
<form action="/danhsachbenhnhan?userAction=search" method="post">
    <table>
        <tr>
            <td><input type="text" name="searchName" placeholder="Enter name "></td>
            <td>
                <button type="submit">Search</button>
            </td>
        </tr>
    </table>
</form>

<h3>Danh Sach Benh An</h3>
<form method="post">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Ma Benh An </th>
            <th>Ma Benh Nhan</th>
            <th>Ngay Nhap Vien </th>
            <th>Ngay Ra Vien</th>
            <th>Ly Do</th>
            <th></th>

        </tr>
        <c:forEach var="benhAn" items="${danhSachBenhAnList}">
            <tr>
                <td>${benhAn.id}</td>

                <td>
                    <c:forEach var="benhAnList" items="${benhAnList}">
                        <c:if test="${benhAnList.id == benhAn.idBenhAn.id}">
                            ${benhAnList.id}
                        </c:if>
                    </c:forEach>
                </td>

                <td>
                    <c:forEach var="benhNhanList" items="${benhNhanList}">
                        <c:if test="${benhNhanList.id == benhAn.idBenhNhan.id}">
                            ${benhNhanList.id}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${benhAn.ngayNhapVien}</td>
                <td>${benhAn.ngayRaVien}</td>
                <td>${benhAn.lyDo}</td>


                <td>
                    <a href="/danhsachbenhnhan?userAction=edit&id=${benhAn.getId()}"
                       onclick="return confirm('Do you want to edit ${benhAn.getId()} ?')">Edit</a>

                    <a href="/danhsachbenhnhan?userAction=delete&id=${benhAn.getId()}"
                       onclick="return confirm('Do you want to delete ${benhAn.getId()} ?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
