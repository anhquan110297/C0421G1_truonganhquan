<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
</head>
<body>
<%--header--%>
<jsp:include page="../layout/header.jsp"/>
<%--body--%>
<div class="container-fluid border border-1">
    <div class="row bg-light">
        <div class="col-lg-2">
            hihihih
        </div>
        <div class="col-lg-10" style="background-color: hotpink">
            <center>
                <button type="button" class="btn btn-primary"><a href="<c:url value="/contract?action=create"/>" style="color: white; text-decoration: none">
                    Create new contract detail
                </a></button>
            </center>
            <table class="table" border="1" cellpadding="5"
                   style="display: inline-block; width: 100%; overflow-x: scroll">
                <thead>
                <tr>
                    <th scope="col">Start Date</th>
                    <th scope="col">End Date</th>
                    <th scope="col">Deposit</th>
                    <th scope="col">Total Money</th>
                    <th scope="col">Employee</th>
                    <th scope="col">Customer</th>
                    <th scope="col">Service</th>
                </tr>
                <thead>
                <c:forEach var="contract" items="${contract}">
                <tbody>
                <tr>
                    <td><c:out value="${contract.getContractStartDate()}"/></td>
                    <td><c:out value="${contract.getContractEndDate()}"/></td>
                    <td><c:out value="${contract.getContractDeposit()}"/></td>
                    <td><c:out value="${contract.getContractTotalMoney()}"/></td>
                    <td><c:out value="${contract.getEmployeeId()}"/></td>
                    <td><c:out value="${contract.getCustomerId()}"/></td>
                    <td><c:out value="${contract.getServiceId()}"/></td>
                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<%--footer--%>
<jsp:include page="../layout/footer.jsp"/>;
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
