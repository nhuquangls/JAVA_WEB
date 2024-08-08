<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/src/css/login.css">
</head>
<body>
    <div class="container d-flex justify-content-center mt-5">
        <div class="login">
            <form action="/login" method="post">
                <h1>Login</h1>
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" maxlength="16" minlength="4" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" maxlength="16" minlength="4" required>
                </div>
                <button class="btn btn-primary">Login</button>
                <a href="/home" class="btn btn-secondary">Cancel</a>
                <c:if test="${requestScope.loginStatus}">
                    <c:redirect url="/home"/>
                </c:if>
                <c:if test="${requestScope.loginStatus == false && requestScope.disabled != true}">
                    <p style="color: red">Wrong account or password</p>
                </c:if>
                <c:if test="${requestScope.disabled}">
                    <p style="color: red">Account is disabled</p>
                </c:if>
            </form><br>
            <p>Don't have account? <a href="/register">Sign up here</a></p>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>
