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
        <div class="col-lg-12">
            <center>
                <button class="btn btn-primary">
                    <a href="/homepage" style="color: white; text-decoration: none">Back to home page</a>
                </button>
                <br>
                <button type="button" class="btn btn-primary"><a href="<c:url value="/customer?action=create"/>" style="color: white; text-decoration: none">
                    Create new customer
                </a></button>
                <br>
                <span><strong style="color: blue">${msg}</strong></span>
            </center>
            <table class="table" border="1" cellpadding="5" style="display: inline-block; width: 100%; overflow-x: scroll" >
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">ID Card</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Type ID</th>
                    <th scope="col">Customer Code</th>
                </tr>
                <thead>
                <c:forEach var="customerList" items="${customerList}">
                    <tbody>
                        <tr>
                            <td><c:out value="${customerList.getId()}"/></td>
                            <td><c:out value="${customerList.getName()}"/></td>
                            <td><c:out value="${customerList.getBirthDay()}"/></td>
                            <td><c:out value="${customerList.getIdCard()}"/></td>
                            <td><c:out value="${customerList.isGender()}"/></td>
                            <td><c:out value="${customerList.getPhone()}"/></td>
                            <td><c:out value="${customerList.getEmail()}"/></td>
                            <td><c:out value="${customerList.getAddress()}"/></td>
                            <td><c:out value="${customerList.getCustomerTypeId()}"/></td>
                            <td><c:out value="${customerList.getCustomerCode()}"/></td>
                                <%--  button edit--%>
                            <td><a href="/customer?action=edit&id=${customerList.getId()}" role="button"
                                   class="btn-primary btn">EDIT</a></td>
                            <td>
                                <!-- Button trigger modal -->
                                <button onclick="onDelete(${customerList.getId()})" type="button"
                                        class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#staticBackdrop">
                                    DELETE
                                </button>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
            <%--   modal--%>
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false"
                 tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel">DELETE CONFIRM</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <form method="post">
                            <input type="hidden" name="action" value="remove">
                            <div class="modal-body">
                                Do you wanna delete <span
<%--                                    style="color: red"><strong>${customerList.getName()}</strong></span>--%>
                            </div>
                            <div class="modal-footer">
                                <input type="hidden" name="id" id="customerId">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No
                                </button>
                                <button type="submit" class="btn btn-primary">Yes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--footer--%>
<jsp:include page="../layout/footer.jsp"/>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

<script>
    function onDelete(id) {
        document.getElementById("customerId").value = id;
    }
</script>
</body>
</html>
