<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập Nhật Phiếu Mượn</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Cập Nhật Phiếu Mượn</h1>
<form action="update" method="post">
    <input type="hidden" name="id" value="${borrowing.id}">

    <label for="status">Trạng Thái:</label><br>
    <select id="status" name="status" required>
        <option value="borrowing" ${borrowing.status == 'borrowing' ? 'selected' : ''}>Đang Mượn</option>
        <option value="returned" ${borrowing.status == 'returned' ? 'selected' : ''}>Đã Trả</option>
        <option value="overdue" ${borrowing.status == 'overdue' ? 'selected' : ''}>Quá Hạn</option>
    </select><br><br>

    <label for="returnDate">Ngày Trả:</label><br>
    <input type="date" id="returnDate" name="returnDate" value="${borrowing.returnDate}"><br><br>

    <button type="submit">Cập Nhật</button>
    <a href="borrowings">Hủy</a>
</form>
</body>
</html>
