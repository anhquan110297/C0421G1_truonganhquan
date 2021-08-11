<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body style="background-color: pink">
<%--header--%>
<jsp:include page="../layout/header.jsp"/>
<%-- bobdy--%>
<div class="container-fluid border border-1">
    <div class="row bg-light">
<%--        side bar--%>
        <div class="col-lg-2">
            hihihih
        </div>
<%--        main body--%>
        <div class="col-lg-10">
            <center>
                <h2>
                    <a href="/employee">List All Employee</a>
                    <caption>
                        <h4>Edit Employee</h4>
                        <h4>Employee Prifole</h4>
                        <span><c:if test="${!empty employee}">
                            <span style="color: blue"><strong>${msg}</strong></span>
                        </c:if></span>
                    </caption>
                </h2>
            </center>
            <form method="post">
                <table class="table">
                    <c:if test="${!empty employee}">
                        <input type="hidden" name="id" value="<c:out value='${employee.id}' />"/>
                    </c:if>
                    <tbody>
                    <tr>
                        <th scope="row">Employee Name :</th>
                        <td>
                            <input type="text" name="name" size="45"
                                   value="${employee.getName()}"/>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Employee BirthDay :</th>
                        <td>
                            <input type="text" name="birthDay" size="45"
                                   value="${employee.getBirthDay()}"/>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Employee ID Card :</th>
                        <td>
                            <input type="text" name="idCard" size="45"
                                   value="${employee.getIdCard()}"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Employee Salary :</th>
                        <td>
                            <input type="text" name="salary" size="45"
                                   value="${employee.getSalary()}"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Employee Phone :</th>
                        <td>
                            <input type="text" name="phone" size="45"
                                   value="${employee.getPhone()}"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Employee Email :</th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="${employee.getEmail()}"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Employee Address :</th>
                        <td>
                            <input type="text" name="address" size="45"
                                   value="${employee.getAddress()}"
                            />
                        </td>
                    </tr>
<%--                                select option--%>
                    <tr>
                        <th scope="row"><label for="positionType">Employee Position</label></th>
                        <td>
                            <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                            <select name="positionId" class="form-select" id="positionType">
                                <c:forEach var="position" items="${positionList}">
                                    <option value='${position.getPositionId()}' >${position.getPositionName()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><label for="employeeEducation">Employee Education Degree</label></th>
                        <td>
                            <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                            <select name="educationDegreeId" class="form-select" id="employeeEducation">
                                <c:forEach var="education" items="${educationDegreeList}">
                                    <option value='${education.getEducationDegreeId()}' >${education.getEducationDegreeName()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"><label for="employeeDivision">Employee Division</label></th>
                        <td>
                            <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                            <select name="divisionId" class="form-select" id="employeeDivision">
                                <c:forEach var="division" items="${divisionList}">
                                    <option value='${division.getDivisionId()}' >${division.getDivisionName()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">Employee User Name :</th>
                        <td>
                            <input type="text" name="userName" size="45"
                                   value="${employee.getUserName()}"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input type="submit" name="" size="45"
                                   value="Save changes"
                            />
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpG
oWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwA
ZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
</body>
</html>
