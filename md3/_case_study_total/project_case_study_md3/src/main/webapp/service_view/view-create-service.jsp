<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
</head>
<body>
<%--header--%>
<jsp:include page="../layout/header.jsp"/>
<%--body--%>
<div class="container-fluid border border-1">
    <div class="row bg-light">
        <div class="col-lg-1">
            hihihih
        </div>
<%--        main body--%>
        <div class="col-lg-11" style="background-color: hotpink">
            <form method="post">
                <center>
                    <h4 style="color: white"><strong>${msg}
                    </strong></h4>
                </center>
                <div class="mb-3">
                    <label for="startDate" class="form-label">Contract Start Date</label>
                    <input type="text" class="form-control" name="startDate" id="startDate">
                </div>
                <div class="mb-3">
                    <label for="endDate" class="form-label">Contract End Date</label>
                    <input type="text" class="form-control" name="endDate" id="endDate">
                </div>
                <div class="mb-3">
                    <label for="deposit" class="form-label">Deposit</label>
                    <input type="text" class="form-control" name="deposit" id="deposit">
                </div>
                <div class="mb-3">
                    <label for="totalMoney" class="form-label">Total Money</label>
                    <input type="text" class="form-control" name="totalMoney" id="totalMoney">
                </div>

                <div class="mb-3">
                    <label for="employee" class="form-label">Employee</label>
                    <select name="employee" class="form-select" id="employee">
                        <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                        <c:forEach var="employee" items="${employee}">
                            <option value='${employee.getId()}'>${employee.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="customer" class="form-label">Customer</label>
                    <select name="customer" class="form-select" id="customer">
                        <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                        <c:forEach var="customer" items="${customer}">
                            <option value='${customer.getId()}'>${customer.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="service" class="form-label">Service</label>
                    <select name="service" class="form-select" id="service">
                        <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                        <c:forEach var="service" items="${service}">
                            <option value='${service.getId()}'>${service.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <input type="submit" value="Create" class="btn btn-danger">
                </div>
            </form>
        </div>
    </div>
</div>
<%--footer--%>
<jsp:include page="../layout/footer.jsp"/>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
