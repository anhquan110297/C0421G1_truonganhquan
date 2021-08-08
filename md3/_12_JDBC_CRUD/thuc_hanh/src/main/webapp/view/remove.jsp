<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <h1> Remove View </h1>
        <span>
            <a href="users?action=users">List All Users</a>
        </span>
    </div>
    <div>
        <form method="post">
            <table border="1">
                <tr>
                    <td>${userRemove.getId()}</td>
                </tr>
                <tr>
                    <td>${userRemove.getName()}</td>
                </tr>
                <tr>
                    <td>${userRemove.getEmail()}</td>
                </tr>
                <tr>
                    <td>${userRemove.getCountry()}</td>
                </tr>
            </table>
            <span>Please re-enter id </span>
            <input type="number" name="idRemove" value="0"> <br>
            <input type="submit" id="submit" value="submit">
        </form>
    </div>

</body>
</html>
