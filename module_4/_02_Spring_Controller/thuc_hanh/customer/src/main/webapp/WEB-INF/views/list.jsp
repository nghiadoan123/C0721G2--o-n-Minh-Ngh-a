<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
<p><a href="/create">Create Customer</a> </p>
<p>${msg}</p>
<p>${msg_one}</p>
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customerList}">
        <tr>
            <td>
                <c:out value="${c.id}"/>
            </td>
            <td>
                <c:out value="${c.name}"/>
            </td>
            <td>
                <c:out value="${c.email}"/>
            </td>
            <td>
                <c:out value="${c.address}"/>
            </td>
            <td>
                <a href="/detail/${c.id}/${c.name}" style="text-decoration: none">Detail Customer</a>
            </td>
            <td>
                <a href="/detail?id=${c.id}&name=${c.name}" style="text-decoration: none">Detail Customer</a>
            </td>
            <td>
                <button><a href="/delete/${c.id}" style="text-decoration: none">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>