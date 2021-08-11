<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employee</title>
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
</head>
<body>
<%--header--%>
<jsp:include page="../layout/header.jsp"/>
<%--body--%>
<div class="container-fluid border border-1">
    <div class="row bg-light">
        <div class="col-lg-12" style="align-content: center">
            <div class="col-lg-12">
                <a href="/employee?action=create"> Add new employee</a>
                <%--            msg neu khong co list--%>
                <br>
                <span style="color: blue"><c:if test="${empty employeeList}">
                    <strong>${msg}</strong>
                </c:if></span>
                <table class="table" border="1" cellpadding="5" style="display: inline-block; width: 100%; overflow-x: scroll" >
                    <thead>
                    <tr>
                        <th scope="col">employee_id</th>
                        <th scope="col">employee_name</th>
                        <th scope="col">employee_birthday</th>
                        <th scope="col">employee_id_card</th>
                        <th scope="col">employee_salary</th>
                        <th scope="col">employee_phone</th>
                        <th scope="col">employee_email</th>
                        <th scope="col">position_id</th>
                        <th scope="col">education_degree_id</th>
                        <th scope="col">division_id</th>
                        <th scope="col">user_name</th>
                    </tr>
                    </thead>
                    <%--                vong lap de duyet ra employee list--%>
                    <c:forEach var="employee" items="${employeeList}">
                        <tbody>
                        <tr>
                            <th><c:out value="${employee.getId()}"/></th>
                            <td><c:out value="${employee.getName()}"/></td>
                            <td><c:out value="${employee.getBirthDay()}"/></td>
                            <td><c:out value="${employee.getIdCard()}"/></td>
                            <td><c:out value="${employee.getSalary()}"/></td>
                            <td><c:out value="${employee.getPhone()}"/></td>
                            <td><c:out value="${employee.getEmail()}"/></td>
                            <td><c:out value="${employee.getAddress()}"/></td>
                            <td><c:out value="${employee.getPositionID()}"/></td>
                            <td><c:out value="${employee.getEducationDegreeID()}"/></td>
                            <td><c:out value="${employee.getDivisionID()}"/></td>
                            <td><c:out value="${employee.getUserName()}"/></td>
                            <td><a href="/employee?action=edit&id=${employee.getId()}" role="button"
                                   class="btn-primary btn">EDIT</a></td>
                            <td>
                                <!-- Button trigger modal -->
                                <button onclick="onDelete(${employee.getId()})" type="button"
                                        class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#staticBackdrop">
                                    DELETE
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
                <!-- Modal -->
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
                                        style="color: red"><strong>${employeeRemove.getName()}</strong></span>
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="id" id="employeeId">
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
</div>
<%--footer--%>
<jsp:include page="../layout/footer.jsp"/>;
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script>
    function onDelete(id) {
        document.getElementById("employeeId").value = id;
    }
</script>
</body>
</html>
