<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Delete Publisher</title>
</head>
<body>
<h1>Are you sure you want to delete this publisher?</h1>
<p>ID: ${publisher.id}</p>
<p>Name: ${publisher.name}</p>
<form action="delete" method="post">
  <input type="hidden" name="id" value="${publisher.id}">
  <button type="submit">Yes, Delete</button>
</form>
<a href="..">Cancel</a>
</body>
</html>
