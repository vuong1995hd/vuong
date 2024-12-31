<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Publisher</title>
</head>
<body>
<h1>Edit Publisher</h1>
<form action="edit" method="post">
    <input type="hidden" name="id" value="${publisher.id}">
    <label for="name">Publisher Name:</label>
    <input type="text" id="name" name="name" value="${publisher.name}" required>
    <button type="submit">Update</button>
</form>
</body>
</html>
