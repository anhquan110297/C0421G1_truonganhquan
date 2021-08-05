<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <h1>Calculator</h1>
      <form action="/result" method="get">
        <input type="text" name="firstOperand" placeholder="First Operand">
        <select name="operator" id="operator">
          <option value="+">addition</option>
          <option value="-">subtraction</option>
          <option value="x">multiple</option>
          <option value=":">division</option>
        </select>
        <input type="text" name="secondOperand" placeholder="Second Operand">
        <input type="submit" id="submit">
      </form>
  </body>
</html>
