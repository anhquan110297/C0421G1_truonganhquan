<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <table border="1px">
        <tr>
          <th>Tên</th>
          <th>Ngày sinh</th>
          <th>Địa chỉ</th>
          <th>img</th>
        </tr>
        <c:forEach var="customerObj" items="${customerListServlet}">
          <tr>
            <td> <c:out value="${customerObj.name}"/></td>
            <td> <c:out value="${customerObj.dateOfBirth}"></c:out></td>
            <td> <c:out value="${customerObj.address}"></c:out></td>
            <td><img src="${customerObj.imgSrc}" style="width: 5%" height="5%"></td>
          </tr>
        </c:forEach>

      </table>
  </body>
</html>
