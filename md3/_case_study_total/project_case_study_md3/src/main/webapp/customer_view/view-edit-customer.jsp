<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit customer</title>
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<div class="container-fluid border border-1">
    <div class="row bg-light">
        <div class="col-lg-2">
            hihihih
        </div>
        <div class="col-lg-10" style="background-color: hotpink">
            <form method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Customer Name</label>
                    <input type="text" class="form-control" name="name" id="name" value="${customer.getName()}">
                </div>
                <div class="mb-3">
                    <label for="birthDay" class="form-label"> Customer BirthDay</label>
                    <input type="date" class="form-control" name="birthday" id="birthDay" value="${customer.getBirthDay()}">
                </div>
                <div class="mb-3">
                    <label for="gender" class="form-label">Gender</label>
                    <select name="gender" id="gender" class="form-select form-control" value="${customer.isGender()}">
                        <option value="false">Female</option>
                        <option value="true">Male</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="idCard" class="form-label">Customer ID Card </label>
                    <input type="text" class="form-control" name="idCard" id="idCard" value="${customer.getIdCard()}">
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Customer Phone</label>
                    <input type="text" class="form-control" name="phone" id="phone" value="${customer.getPhone()}">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Customer Email</label>
                    <input type="email" class="form-control" name="email" id="email" value="${customer.getEmail()}">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Customer Address</label>
                    <input type="text" class="form-control" name="address" id="address" value="${customer.getAddress()}">
                </div>
                <div class="mb-3">
                    <label for="customerType" class="form-label">Customer Type</label>
                    <select name="customerTypeId" class="form-select" id="customerType" value="${customer.getCustomerTypeId()}">
                        <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <option value='${customerType.getCustomerTypeId()}'>
                                    ${customerType.getCustomerName()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Customer Code</label>
                    <input type="text" class="form-control" name="customerCode" id="customerCode" value="${customer.getCustomerCode()}"/>
                </div>
                <div class="d-grid gap-2">
                    <button class="btn btn-primary" type="submit">create</button>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
