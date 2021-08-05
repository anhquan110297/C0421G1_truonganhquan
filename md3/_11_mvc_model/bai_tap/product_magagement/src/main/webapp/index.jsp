<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product List</title>
  </head>
  <body>
  <h2>Product List</h2>
  <table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th colspan="4"></th>
    </tr>
    <c:forEach items="${product}" var="products">
        <tr>
            <td><a href="/products?action=view&id=${products.getId()}">
                ${products.getName()}
            </a></td>
            <td>${products.getDescription()}</td>
            <td>${products.getPrice()}</td>
            <td><a href="/products?action=edit&id=${products.getId()}">Edit Products</a></td>
            <td><a href="/products?action=delete&id=${products.getId()}">Delete Products</a></td>
        </tr>
    </c:forEach>
      <td colspan="6" style="text-align: center"><a href="/products?action=search">Search Product</a></td>
      <td colspan="6" style="text-align: center"><a href="/products?action=add">Add Products</a></td>
  </table>
  </body>
</html>
