<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa Danh Mục</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Sửa Danh Mục</h1>
<form action="edit" method="post">
    <input type="hidden" name="id" value="${category.id}">
    <label for="name">Tên Danh Mục:</label><br>
    <input type="text" id="name" name="name" value="${category.name}" required><br><br>
    <button type="submit">Cập Nhật</button>
    <a href="categories">Hủy</a>
</form>
</body>
</html>