<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Xóa Sách</title>
  <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Xác Nhận Xóa Sách</h1>
<form action="delete" method="post">
  <input type="hidden" name="id" value="${book.id}">
  <p>Bạn có chắc chắn muốn xóa sách: <strong>${book.name}</strong> không?</p>
  <button type="submit">Xóa</button>
  <a href="books">Hủy</a>
</form>
</body>
</html>