<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa Danh Mục</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Xác Nhận Xóa Danh Mục</h1>
<form action="delete" method="post">
    <input type="hidden" name="id" value="${category.id}">
    <p>Bạn có chắc chắn muốn xóa danh mục: <strong>${category.name}</strong> không?</p>
    <button type="submit">Xóa</button>
    <a href="categories">Hủy</a>
</form>
</body>
</html>
