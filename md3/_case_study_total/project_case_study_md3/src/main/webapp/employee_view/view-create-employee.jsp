<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<div class="container-fluid border border-1">
    <div class="row bg-light">
<%--        side bar--%>
        <div class="col-lg-2">
            create hihi
        </div>
<%--        main body--%>
        <div class="col-lg-10">
            <div align="center">
                <span><c:if test="msg != null">
                    ${msg}
                </c:if></span>
                <table border="1" cellpadding="5">
                    <form method="post">
                        <caption><h5> Create New Employee</h5></caption>
                        <tr>
                            <th>Employee Name</th>
                            <td>
                                <input type="text" name="name" id="name">
                            </td>
                        </tr>
                        <tr>
                            <th>Employee BirthDay</th>
                            <td>
                                <input type="text" name="birthday" id="birthday">
                            </td>
                        </tr>
                        <tr>
                            <th>Employee ID Card</th>
                            <td>
                                <input type="text" name="idCard" id="idCard">
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Salary</th>
                            <td>
                                <input type="text" name="salary" id="salary">
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Phone</th>
                            <td>
                                <input type="text" name="phone" id="phone">
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Email</th>
                            <td>
                                <input type="text" name="email" id="email">
                            </td>
                        </tr>
                        <tr>
                            <th>Employee Address</th>
                            <td>
                                <input type="text" name="address" id="address">
                            </td>
                        </tr>
                        <tr>
                            <th><label for="positionType">Employee Position</label></th>
                            <td>
<%--                                name = "" được lấy từ phương thức post để get về giá trị--%>
                                <select name="positionID" class="form-select" id="positionType">
                                    <c:forEach var="position" items="${positionList}">
                                        <option value='${position.getPositionId()}' >${position.getPositionName()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="employeeEducation">Employee Education Degree</label></th>
                            <td>
                                <%--  name = "" được lấy từ phương thức post để get về giá trị--%>

                                <select name="educationDegreeID" class="form-select" id="employeeEducation">
                                    <c:forEach var="education" items="${educationDegreeList}">
                                        <option value='${education.getEducationDegreeId()}' >${education.getEducationDegreeName()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="employeeDivision">Employee Division</label></th>
                            <td>
                                <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                                <select name="divisionID" class="form-select" id="employeeDivision">
                                    <c:forEach var="division" items="${divisionList}">
                                        <option value='${division.getDivisionId()}' >${division.getDivisionName()}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>Employee User Name</th>
                            <td>
                                <input type="text" name="userName" id="userName">
                            </td>
                        </tr>
                        <tr>
                            <button type="submit" value="Create">Create</button>
                        </tr>
                    </form>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>;
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpG
oWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwA
ZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
</body>
</html>
