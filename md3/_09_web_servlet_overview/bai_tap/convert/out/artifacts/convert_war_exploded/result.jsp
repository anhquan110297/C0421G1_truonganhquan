<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/3/2021
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
    <span>Description : <%=request.getAttribute("description")%></span>
    <span>ListPrice : <%=request.getAttribute("ListPrice")%></span>
    <span>Discount Percent : <%=request.getAttribute("percent")%></span>
    <span>Discount Amount : <%=request.getAttribute("discountAmount")%></span>
    <span>Discount Price : <%=request.getAttribute("discountPrice")%></span>
</body>
</html>
