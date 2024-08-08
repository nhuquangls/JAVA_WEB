<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid header">
    <div class="container">
        <div class="row d-flex align-items-center justify-content-between">
            <div class="logo col-12 col-lg-4 d-flex justify-content-center">
                <a href="/home"><img src="/views/src/img/logo.png" alt="logo"></a>
            </div>
            <div class="search-form col-5 col-md-5 d-none d-lg-block">
                <form method="post" class="d-flex" action="/search">
                    <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search" name="search">
                    <button type="submit" class="btn btn-outline-light me-2">
                        <box-icon name='search' color='#fbf7f7' ></box-icon>
                    </button>
                </form>
            </div>
            <c:set var="user" value="${sessionScope.user}"/>
            <div class="login-form col-4 col-lg-3 d-none d-lg-flex justify-content-end">
                <c:if test="${user == null}">
                    <a href="${pageContext.request.contextPath}/login"><button type="button" class="btn btn-outline-light me-2">Login</button></a>
                    <a href="${pageContext.request.contextPath}/register"><button type="button" class="btn btn-warning">Sign-up</button></a>
                </c:if>
                <c:if test="${user != null}">
                    <div class="dropdown">
                        <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="/views/src/img/user_icon.jpg" alt="" width="32" height="32" class="rounded-circle me-2">
                            <strong class="text-light">${user.username}</strong>
                        </a>
                        <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2" style="">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/post?action=create">New Post</a></li>
                            <li><a class="dropdown-item" href="#">Profile</a></li>
                            <c:if test="${user.role.role_name == 'admin'}">
                                <li><a class="dropdown-item" href="/admin">Admin manager</a></li>
                            </c:if>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Sign out</a></li>
                        </ul>
                    </div>
                </c:if>
            </div>

        </div>
    </div>
</div>
