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
            <center>
                <button class="btn btn-primary">
                    <a href="/homepage" style="color: white; text-decoration: none">Back to home page</a>
                </button>
                <br>
                <button type="button" class="btn btn-primary"><a href="<c:url value="/product?action=create"/>" style="color: white; text-decoration: none">
                    Create new Product
                </a></button>
                <br>
                <span><strong style="color: blue">${msg}</strong></span>
            </center>
            <table class="table" border="1" cellpadding="5" style="display: inline-block; width: 100%; overflow-x: scroll; align-content: center" >
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Description</th>
                    <th scope="col">Color</th>
                    <th scope="col">Category</th>
                    <th scope="col">Action</th>
                </tr>
                <thead>
<%--                    vong lap o day dien` list--%>
                <c:forEach var="productList" items="${productList}">
                <tbody>
                <tr>
                    <td><c:out value="${productList.getIdProduct()}"/></td>
                    <td><c:out value="${productList.getName()}"/></td>
                    <td><c:out value="${productList.getPrice()}"/></td>
                    <td><c:out value="${productList.getAmount()}"/></td>
                    <td><c:out value="${productList.getDescription()}"/></td>
                    <td><c:out value="${productList.getIdColor()}"/></td>
                    <td><c:out value="${productList.getIdCategory()}"/></td>
                        <%--  button edit--%>
<%--                    sua lai customer--%>
                        <!-- Button trigger modal -->
                    <td>
                        <button onclick="onDelete('${productList.getIdProduct()}','${productList.getName()}')" type="button"
                                class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#staticBackdrop">
                            DELETE
                        </button>
                    </td>
                </tr>
                </tbody>
                </c:forEach>
            </table>
<%--            search--%>
            <form method="post">
                <input class="form-control me-2" type="search" placeholder="Search By Name" aria-label="Search" name="searchName">
                <button class="btn btn-outline-success" type="submit" name="action" value="searchName">Search</button>
            </form>
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
                                Do you wanna delete <input type="text" id="productName" readonly style="border: none; color: red">
                            </div>
                            <div class="modal-footer">
                                <input type="hidden" name="id" id="productId">
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
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script>
    function onDelete(id , name) {
        document.getElementById("productId").value = id;
        document.getElementById("productName").value = name;
    }
</script>
</body>
</html>
