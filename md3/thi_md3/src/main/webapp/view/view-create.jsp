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
        <div class="col-lg-12">
            <div>
                <%--  form create--%>
                <center>
                    <span style="color: blue"><strong>${msg}</strong></span>
                    <div class="d-grid gap-2">
                        <button class="btn btn-primary" type="submit">
                            <a href="/product" style="text-decoration: none;color: white">Back to list</a>
                        </button>
                    </div>
                </center>
                <form method="post">
                    <div class="mb-3">
                        <label for="name" class="form-label">Product Name</label>
                        <input type="text" class="form-control" name="name" id="name">

                    </div>
                    <div class="mb-3">
                        <label for="price" class="form-label">Product price</label>
                        <input type="text" class="form-control" name="price" id="price">

                    </div>
                    <div class="mb-3">
                        <label for="amount" class="form-label">Product amount</label>
                        <input type="text" class="form-control" name="amount" id="amount">
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label">Product description</label>
                        <input type="text" class="form-control" name="description" id="description">

                    </div>
                    <div class="mb-3">
                        <label for="color" class="form-label">Color</label>
                        <select name="idColor" class="form-select" id="color">
                            <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                            <c:forEach var="colorList" items="${colorList}">
                                <option value='${colorList.getIdColor()}'>${colorList.getNameColor()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="category" class="form-label">Category</label>
                        <select name="idCategory" class="form-select" id="category">
                            <%--  name = "" được lấy từ phương thức post để get về giá trị--%>
                            <c:forEach var="categoryList" items="${categoryList}">
                                <option value='${categoryList.getIdCategory()}'>${categoryList.getNameCategory()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="d-grid gap-2">
                        <button class="btn btn-primary" type="submit">Create</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
