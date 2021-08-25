
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/sandwich" method="get">
        <input type="checkbox" id="lettuce" name="condiment" value="Lettuce">
        <label for="lettuce">Lettuce</label><br>
        <input type="checkbox" id="tomato" name="condiment" value="Tomato">
        <label for="tomato">Tomato</label><br>
        <input type="checkbox" id="mustard" name="condiment" value="Mustard">
        <label for="mustard">Mustard</label><br>
        <input type="checkbox" id="sprouts" name="condiment" value="Sprouts">
        <label for="sprouts">Sprouts</label><br>
        <input type="submit" value="submit">
    </form>
    <h3>Condiment : ${condiment}</h3>
    <hr>
    <form action="/operation">
        <label for="numberA">First Number</label>
        <input type="text" id="numberA" name="numberA">
        <label for="operator"></label>
        <select name="operator" id="operator">
            <option value="plus">+</option>
            <option value="subtract">-</option>
            <option value="multi">x</option>
            <option value="divine">:</option>
        </select>
        <label for="numberB">Second Number</label>
        <input type="text" id="numberB" name="numberB">
        <input type="submit" value="submit">
    </form>
    <span style="color: red">Result : ${result2}</span>
</body>
</html>
