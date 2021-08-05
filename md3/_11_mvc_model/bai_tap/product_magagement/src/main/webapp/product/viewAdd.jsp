<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view add</title>
</head>
<body>
<h1>View Add Jsp</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>Name :</tr>
            <tr><input type="text" name="name" id="name"></tr>
            <tr>Description :</tr>
            <tr><input type="text" name="description" id="description"></tr>
            <tr>Price :</tr>
            <tr><input type="text" name="price" id="price"></tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
