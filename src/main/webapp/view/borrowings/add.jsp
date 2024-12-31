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
    <title>Tạo Phiếu Mượn</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Tạo Phiếu Mượn</h1>
<form action="add" method="post">
    <label for="customerId">Khách Hàng:</label><br>
    <select id="customerId" name="customerId" required>
        <c:forEach var="customer" items="${customers}">
            <option value="${customer.id}">${customer.name}</option>
        </c:forEach>
    </select><br><br>

    <label for="bookId">Sách:</label><br>
    <select id="bookId" name="bookId" required>
        <c:forEach var="book" items="${books}">
            <option value="${book.id}">${book.name}</option>
        </c:forEach>
    </select><br><br>

    <label for="borrowDate">Ngày Mượn:</label><br>
    <input type="date" id="borrowDate" name="borrowDate" required><br><br>

    <button type="submit">Tạo Phiếu Mượn</button>
    <a href="borrowings">Hủy</a>
</form>
</body>
</html>