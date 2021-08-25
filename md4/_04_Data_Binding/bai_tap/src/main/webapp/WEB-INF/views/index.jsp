<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"></head>
<body>
<div class="container-fluid">
    <center>
        <h3>Medical Declaration Form</h3>
        <p style="color: red">Warning: Declaring false information is a violation of Vietnamese law and may be subject
            to criminal prosecution</p>
        <span style="color: #0a53be">${msg}</span>
        <form:form modelAttribute="newPerson" action="/person/create" method="post" cssClass="row g-3">
            <div class="col-md-12">
                <label for="fullName" class="form-label">Full Name</label>
                <form:input path="name" cssClass="form-control" id="fullName" />
            </div>
            <div class="col-md-4">
                <label for="age" class="form-label">Age</label>
                <form:input path="age" type="text" class="form-control" id="age"/>
            </div>
            <div class="col-4">
                <label for="gender" class="form-label">Gender</label>
                <form:select path="gender" type="text" cssClass="form-select" id="gender">
                    <form:option value="false"> Female</form:option>
                    <form:option value="true"> Male</form:option>
                </form:select>
            </div>
            <div class="col-4">
                <label for="country" class="form-label">Country</label>
                <form:select path="country"  cssClass="form-select" id="country">
                    <form:options items="${country}"/>
                </form:select>
            </div>
            <div class="col-12">
                <label for="idCard" class="form-label">ID Card</label>
                <form:input path="idCard" type="text" cssClass="form-control" id="idCard"/>
            </div>
            <div class="col-md-12">
                <label for="transport" class="form-check-label ml-2">Transports</label><br>
                <form:radiobuttons path="transport" id="transport" cssClass="form-check-input"
                                   cssStyle="margin-right: 5px; padding-left: 10px; padding-right: 5px " items="${transport}"/>
            </div>
            <div class="col-md-6">
                <label for="idTransport" class="form-label">ID Transport</label>
                <form:input path="idTransport" cssClass="form-control" id="idTransport"/>
            </div>
            <div class="col-md-6">
                <label for="idSeat" class="form-label">ID seat</label>
                <form:input path="idSeat" cssClass="form-control" id="idSeat"/>
            </div>
            <div class="col-md-6">
                <label for="startDay" class="form-label">Start Day</label>
                <form:input path="startDate" cssClass="form-control" id="startDay"/>
            </div>
            <div class="col-md-6">
                <label for="endDay" class="form-label">End Day</label>
                <form:input path="endDate" cssClass="form-control" id="endDay"/>
            </div>
            <div class="col-md-12">
                <label for="travel" class="form-label">Travel</label>
                <form:input path="travelCity" cssClass="form-control" id="travel"/>
            </div>
            <div class="col-md-4">
                <label for="address" class="form-label">Address</label>
                <form:input path="address" cssClass="form-control" id="address"/>
            </div>
            <div class="col-md-4">
                <label for="phone" class="form-label">Phone</label>
                <form:input path="phone" cssClass="form-control" id="phone"/>
            </div>
            <div class="col-md-4">
                <label for="email" class="form-label">Email</label>
                <form:input path="email" cssClass="form-control" id="email"/>
            </div>
            <div class="col-md-12">
                <label for="symptom" class="form-label">Symptom</label><br>
                <form:checkboxes path="symptom" id="symptom" cssClass="form-check-input" cssStyle="margin-left: 20px; padding-left: 10px " items="${symptom}"/>
            </div>
            <div class="class-md-12">
                <button class="btn btn-primary">Submit</button>
            </div>
        </form:form>
    </center>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
