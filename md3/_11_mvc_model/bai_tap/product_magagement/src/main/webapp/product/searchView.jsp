<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/products">Back to product list </a>
    <h1>Search Product</h1>
    <form method="post">
        <input type="text" name="name_product">
        <input type="submit" value="submit search" id="submit">
    </form>
</body>
</html>
