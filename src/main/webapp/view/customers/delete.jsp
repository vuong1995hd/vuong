<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Xóa Khách Hàng</title>
  <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Xác Nhận Xóa Khách Hàng</h1>
<form action="delete" method="post">
  <input type="hidden" name="id" value="${customer.id}">
  <p>Bạn có chắc chắn muốn xóa khách hàng: <strong>${customer.name}</strong> không?</p>
  <button type="submit">Xóa</button>
  <a href="customers">Hủy</a>
</form>
</body>
</html>