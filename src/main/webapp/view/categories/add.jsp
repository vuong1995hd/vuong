<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Danh Mục</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Thêm Danh Mục</h1>
<form action="add" method="post">
    <label for="name">Tên Danh Mục:</label><br>
    <input type="text" id="name" name="name" required><br><br>
    <button type="submit">Thêm</button>
    <a href="categories">Hủy</a>
</form>
</body>
</html>