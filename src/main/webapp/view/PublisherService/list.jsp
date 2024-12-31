<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Publisher List</title>
</head>
<body>
<h1>Publisher List</h1>
<a href="add">Add New Publisher</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="publisher" items="${publishers}">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>
            <td>
                <a href="edit?id=${publisher.id}">Edit</a>
                <a href="delete?id=${publisher.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
