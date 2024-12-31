<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sửa Khách Hàng</title>
  <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Sửa Khách Hàng</h1>
<form action="edit" method="post">
  <input type="hidden" name="id" value="${customer.id}">

  <label for="name">Tên Khách Hàng:</label><br>
  <input type="text" id="name" name="name" value="${customer.name}" required><br><br>

  <label for="code">Mã Khách Hàng:</label><br>
  <input type="text" id="code" name="code" value="${customer.code}" required><br><br>

  <label for="schoolClass">Lớp/Trường:</label><br>
  <input type="text" id="schoolClass" name="schoolClass" value="${customer.schoolClass}" required><br><br>

  <label for="address">Địa Chỉ:</label><br>
  <input type="text" id="address" name="address" value="${customer.address}" required><br><br>

  <label for="birthDate">Ngày Sinh:</label><br>
  <input type="date" id="birthDate" name="birthDate" value="${customer.birthDate}" required><br><br>

  <button type="submit">Cập Nhật</button>
  <a href="customers">Hủy</a>
</form>
</body>
</html>
