<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/3/2021
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
    <h3> <%=request.getAttribute("word")%></h3>
    <h3> <%=request.getAttribute("result")%></h3>
    <h3> <%=request.getAttribute("not_found")%></h3>
</body>
</html>
