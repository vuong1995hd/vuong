<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Sách</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Thêm Sách</h1>
<form action="add" method="post" enctype="multipart/form-data">
    <%--@declare id="status"--%><label for="name">Tên Sách:</label><br>
    <input type="text" id="name" name="name" required><br><br>

    <label for="description">Mô Tả:</label><br>
    <textarea id="description" name="description" rows="4" cols="50" required></textarea><br><br>

    <label for="image">Hình Ảnh:</label><br>
    <input type="file" id="image" name="image" accept="image/*" required><br><br>

    <label for="status">Tình Trạng:</label><br>
    <input type="radio" id="new" name="status" value="new" required>
    <label for="new">Mới</label>
    <input type="radio" id="old" name="status" value="old" required>
    <label for="old">Cũ</label><br><br>

    <label for="categoryId">Thể Loại:</label><br>
    <select id="categoryId" name="categoryId" required>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select><br><br>

    <label for="publisherId">Nhà Xuất Bản:</label><br>
    <select id="publisherId" name="publisherId" required>
        <c:forEach var="publisher" items="${publishers}">
            <option value="${publisher.id}">${publisher.name}</option>
        </c:forEach>
    </select><br><br>

    <button type="submit">Thêm</button>
    <a href="books">Hủy</a>
</form>
</body>
</html>
