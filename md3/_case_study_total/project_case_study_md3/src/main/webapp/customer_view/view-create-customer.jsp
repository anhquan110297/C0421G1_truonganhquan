<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<div class="container-fluid border border-1">
    <div class="row bg-light">
        <div class="col-lg-2">
            hihihih
        </div>
        <div class="col-lg-10">
            <div>
                <%--                form create--%>
                <center>
                     <span style="color: blue"><strong>${msg}</strong></span>
                </center>
                <form method="post">
                    <div class="mb-3">
                        <label for="name" class="form-label">Customer Name</label>
                        <input type="text" class="form-control" name="name" id="name">
                        <small>
                            ${nameValidate}
                        </small>
                    </div>
                    <div class="mb-3">
                        <label for="birthDay" class="form-label"> Customer BirthDay</label>
                        <input type="date" class="form-control" name="birthDay" id="birthDay">
                    </div>
                    <div class="mb-3">
                        <label for="gender" class="form-label">Gender</label>
                        <select name="gender" id="gender" class="form-select form-control">
                            <option value="false">Female</option>
                            <option value="true">Male</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="idCard" class="form-label">Customer ID Card </label>
                        <input type="text" class="form-control" name="idCard" id="idCard">
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Customer Phone</label>
                        <input type="text" class="form-control" name="phone" id="phone">
                        <small>
                            ${phoneValidate}
                        </small>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Customer Email</label>
                        <input type="email" class="form-control" name="email" id="email">
                        <small>
                            ${emailValidate}
                        </small>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Customer Address</label>
                        <input type="text" class="form-control" name="address" id="address">
                    </div>
                    <div class="mb-3">
                        <label for="customerType" class="form-label">Customer Type</label>
                        <select name="customerTypeId" class="form-select" id="customerType">
                            <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                            <c:forEach var="customerType" items="${customerType}">
                                <option value='${customerType.getCustomerTypeId()}'>${customerType.getCustomerName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Customer Code</label>
                        <input type="text" class="form-control" name="customerCode" id="customerCode">
                        <small>
                            ${customerCodeValidate}
                        </small>
                    </div>
                    <div class="d-grid gap-2">
                        <button class="btn btn-primary" type="submit">create</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
