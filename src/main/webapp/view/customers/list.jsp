<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Danh sách khách hàng</h1>
<a href="add">Thêm khách hàng mới</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mã KH</th>
        <th>Lớp/Trường</th>
        <th>Địa chỉ</th>
        <th>Ngày sinh</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.code}</td>
            <td>${customer.schoolClass}</td>
            <td>${customer.address}</td>
            <td>${customer.birthDate}</td>
            <td>
                <a href="edit?id=${customer.id}">Sửa</a>
                <a href="delete?id=${customer.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>