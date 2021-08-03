<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/3/2021
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form action="/dictionary" method="get">
    <input type="text" name="txtsearch" placeholder="Enter your word: "/>
    <input type="submit" id="sumit" value="Search"/>
  </form>
  </body>
</html>
