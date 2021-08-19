<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap-grid.min.css">
</head>
<body>
<%--header--%>
<jsp:include page="../layout/header.jsp"/>
<%--body--%>
<div class="container-fluid border border-1">
    <div class="row bg-light">
        <div class="col-lg-1" style="background-color: hotpink;">
            hihihih
        </div>
        <%--        main body--%>
        <div class="col-lg-11" style="background-color: hotpink">
            <center>
                <button class="btn" style="background-color: hotpink">
                    <a href="/service?action=create" style="text-decoration: none; color: white">
                        Create new service
                    </a>
                </button>
            </center>

        </div>
    </div>
</div>
<%--footer--%>
<jsp:include page="../layout/footer.jsp"/>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
