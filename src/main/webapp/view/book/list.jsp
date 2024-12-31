<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Sách</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Danh sách Sách</h1>
<a href="add">Thêm Sách Mới</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên Sách</th>
        <th>Mô Tả</th>
        <th>Hình Ảnh</th>
        <th>Tình Trạng</th>
        <th>Thể Loại</th>
        <th>Nhà Xuất Bản</th>
        <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.description}</td>
            <td><img src="${book.imagePath}" alt="Book Image" width="100"></td>
            <td>${book.status}</td>
            <td>${book.categoryName}</td>
            <td>${book.publisherName}</td>
            <td>
                <a href="edit?id=${book.id}">Sửa</a>
                <a href="delete?id=${book.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>