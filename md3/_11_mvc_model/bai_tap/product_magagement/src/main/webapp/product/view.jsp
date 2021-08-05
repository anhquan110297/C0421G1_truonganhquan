<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view</title>
</head>
<body>
<h1>Product Details</h1>
<span>
    <a href="/products">Back to product list </a>
</span>
<table>
    <tr>
        <td>Name: </td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${product.getDescription()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.getPrice()}</td>
    </tr>
</table>
</body>
</html>
