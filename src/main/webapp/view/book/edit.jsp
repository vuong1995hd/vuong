<%--
  Created by IntelliJ IDEA.
  User: dell 3541
  Date: 12/30/2024
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa Sách</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<h1>Sửa Sách</h1>
<form action="edit" method="post" enctype="multipart/form-data">
    <%--@declare id="status"--%><input type="hidden" name="id" value="${book.id}">

    <label for="name">Tên Sách:</label><br>
    <input type="text" id="name" name="name" value="${book.name}" required><br><br>

    <label for="description">Mô Tả:</label><br>
    <textarea id="description" name="description" rows="4" cols="50" required>${book.description}</textarea><br><br>

    <label for="image">Hình Ảnh (Để trống nếu không muốn thay đổi):</label><br>
    <input type="file" id="image" name="image" accept="image/*"><br><br>

    <label for="status">Tình Trạng:</label><br>
    <input type="radio" id="new" name="status" value="new" ${book.status == 'new' ? 'checked' : ''}>
    <label for="new">Mới</label>
    <input type="radio" id="old" name="status" value="old" ${book.status == 'old' ? 'checked' : ''}>
    <label for="old">Cũ</label><br><br>

    <label for="categoryId">Thể Loại:</label><br>
    <select id="categoryId" name="categoryId" required>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}" ${book.categoryId == category.id ? 'selected' : ''}>${category.name}</option>
        </c:forEach>
    </select><br><br>

    <label for="publisherId">Nhà Xuất Bản:</label><br>
    <select id="publisherId" name="publisherId" required>
        <c:forEach var="publisher" items="${publishers}">
            <option value="${publisher.id}" ${book.publisherId == publisher.id ? 'selected' : ''}>${publisher.name}</option>
        </c:forEach>
    </select><br><br>

    <button type="submit">Cập Nhật</button>
    <a href="books">Hủy</a>
</form>
</body>
</html>
