<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/3/2021
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/discount" method="get">
    <input type="text" name="description" placeholder="description">
    <input type="text" name="listPricce" placeholder="listPrice">
    <input type="text" name="percent" placeholder="percent">
    <input type="submit" id="submit" value="Calculate Discount">
  </form>
  </body>
</html>
