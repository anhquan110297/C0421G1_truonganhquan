
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      span {
        color: red;
      }
    </style>
  </head>
  <body>
  <form method="post" action="/moneyconvert">
    <input type="text" name="vnd">
    <input type="submit" role="button">
  </form>
    <span>Result : ${usd}</span>
  <hr>
  <hr>
  <form action="dictionary" method="post">
    <input type="text" name="vietnamese">
    <input type="submit" role="button">
  </form>
  <span>Result 2 : ${result2}</span> <br>
  <span>Result 2 : ${msg}</span>
  </body>
</html>
