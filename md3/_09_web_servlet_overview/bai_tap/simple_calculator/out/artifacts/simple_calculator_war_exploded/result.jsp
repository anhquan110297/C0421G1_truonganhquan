<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Calculator</h1>
    <span>
       first : <c:out value="${firstOperand}" />
    </span>
    <br>
    <span>
        <c:choose>
            <c:when test="${operator == addition}">
                <c:out value="+"/>
            </c:when>
            <c:when test="${operator eq subtraction}">
                <c:out value="-"/>
            </c:when>
            <c:when test="${operator eq multiple }">
                <c:out value="x"/>
            </c:when>
            <c:when test="${operator eq division }">
                <c:out value=":"/>
            </c:when>
        </c:choose>
    </span>
    <br>
    <span>
        <c:out value="${secondOperand}" />
    </span>
    <br>
    <span>
       result :  <c:out value="${result}"/>
    </span>

</body>
</html>
