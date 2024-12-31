<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Phiếu Mượn</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Danh sách Phiếu Mượn</h1>
<a href="add">Tạo Phiếu Mượn</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Khách Hàng</th>
        <th>Sách</th>
        <th>Ngày Mượn</th>
        <th>Ngày Trả</th>
        <th>Trạng Thái</th>
        <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="borrowing" items="${borrowings}">
        <tr>
            <td>${borrowing.id}</td>
            <td>${borrowing.customerId}</td>
            <td>${borrowing.bookId}</td>
            <td>${borrowing.borrowDate}</td>
            <td>${borrowing.returnDate}</td>
            <td>${borrowing.status}</td>
            <td>
                <a href="update?id=${borrowing.id}">Cập Nhật</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
