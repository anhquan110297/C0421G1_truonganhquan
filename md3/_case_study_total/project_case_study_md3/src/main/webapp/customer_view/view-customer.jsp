<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
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
        <div class="col-lg-10">
            <center>
                <button class="btn btn-primary">
                    <a href="/homepage" style="color: white; text-decoration: none">Back to home page</a>
                </button>
            </center>
            <table class="table" border="1" cellpadding="5" style="display: inline-block; width: 100%; overflow-x: scroll" >
                <thead>
                <tr>
                    <th scope="col">customer_id</th>
                    <th scope="col">customer_name</th>
                    <th scope="col">customer_birthday</th>
                    <th scope="col">customer_gender</th>
                    <th scope="col">customer_id_card</th>
                    <th scope="col">customer_phone</th>
                    <th scope="col">customer_email</th>
                    <th scope="col">customer_address</th>
                    <th scope="col">customer_type_id</th>
                </tr>
                <thead>
                <c:forEach var="customerlist" items="${customerlist}">
                    <tbody>
                        <tr>
                            <td><c:out value="${customerlist.getId()}"/></td>
                            <td><c:out value="${customerlist.getName()}"/></td>
                            <td><c:out value="${customerlist.getBirthDay()}"/></td>
                            <td><c:out value="${customerlist.getGender()}"/></td>
                            <td><c:out value="${customerlist.getPhone()}"/></td>
                            <td><c:out value="${customerlist.getEmail()}"/></td>
                            <td><c:out value="${customerlist.getAddress()}"/></td>
                            <td><c:out value="${customerlist.getCustomerTypeId()}"/></td>
                                <%--  button edit--%>
                            <td><a href="/customer?action=edit&id=${customerlist.getId()}" role="button"
                                   class="btn-primary btn">EDIT</a></td>
                            <td>
                                <!-- Button trigger modal -->
                                <button onclick="onDelete(${customerlist.getId()})" type="button"
                                        class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#staticBackdrop">
                                    DELETE
                                </button>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<%--footer--%>
<jsp:include page="../layout/footer.jsp"/>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
