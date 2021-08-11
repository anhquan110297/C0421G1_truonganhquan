    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css">
        </head>
        <body>
        <!-- homepage-->
        <div class="container-fluid border border-1">
        <div class="row bg-light">
        <div class="col-lg-6">
        <a href="#" style="color: pink">
        <!-- icon-->
        <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" fill="currentColor" class="bi bi-house-door"
        viewBox="0 0 16 16">
        <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0
        .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0
        0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-
        .5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"></path>
        </svg>
        </a>
        </div>
        <div class="col-lg-6" style="text-align: right">Trương Anh Quân</div>
        </div>
        </div>
        <!--navbar-->
        <nav class="navbar navbar-light bg-light border border-1">
        <div class="container-fluid">
        <a class="navbar-brand" href="/homepage">Home</a>
        <a class="navbar-brand" href="/employee">Employee</a>
        <a class="navbar-brand" href="/customer">Customer</a>
        <a class="navbar-brand" href="/service">Service</a>
        <a class="navbar-brand" href="/contract">Contract</a>
        <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        </div>
        </nav>
        <script src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="../bootstrap/js/bootstrap.bundle.min.js"></script>
        </body>
        </html>
