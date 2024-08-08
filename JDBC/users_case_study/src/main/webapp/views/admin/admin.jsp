<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/src/css/admin.css">
</head>
<body>
<c:set var="users" value="${requestScope.users}"/>
<c:set var="posts" value="${requestScope.posts}"/>
<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px; height: 100vh;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
        <span class="fs-4">Admin</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
            <a href="/home" class="nav-link active" aria-current="page">
                <box-icon name='home' color="#ffffff"></box-icon>
                Home
            </a>
        </li>
        <li>
            <a href="/admin?target=users" class="nav-link text-white">
                <box-icon name='user-account' color="#ffffff" type='solid' ></box-icon>
                Users Manager
            </a>
        </li>
        <li>
            <a href="/admin?target=posts" class="nav-link text-white">
                <box-icon name='book-content' color="#ffffff" type='solid' ></box-icon>
                Posts Manager
            </a>
        </li>
    </ul>
    <hr>
    <a href="/logout" class="nav-link text-white">
        <box-icon name='log-out'color="#ffffff" ></box-icon>
        Logout
    </a>
</div>
<div class="container-fluid p-0">
    <div class="header d-flex justify-content-end pe-5">
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="/views/src/img/user_icon.jpg" alt="" width="32" height="32" class="rounded-circle me-2">
                <strong>Admin</strong>
            </a>
            <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
                <a class="dropdown-item h-50" href="/logout">Sign out</a>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="content p-5">
            <h3>Dashboard</h3>
            <c:if test="${users!=null}">
                <c:import url="/views/admin/usersmanager.jsp"/>
            </c:if>
            <c:if test="${posts!=null}">
                <c:import url="/views/admin/postsmanager.jsp"/>
            </c:if>
        </div>
    </div>
    <div class="footer bg-white">
        <div class="container my-auto">
            <div class="text-center">
                <span>Copyright © Your Website 2024</span>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
</html>
