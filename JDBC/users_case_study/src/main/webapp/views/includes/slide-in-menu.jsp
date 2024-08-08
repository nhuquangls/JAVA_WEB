<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .offcanvas {
        transition: transform 0.3s ease-in-out;
    }
</style>
<div class="offcanvas offcanvas-start bg-dark p-5" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header ms-1">
        <h5 class="offcanvas-title text-light" id="offcanvasExampleLabel"><a href="/home"><box-icon name='home' color="#ffffff"></box-icon></a></h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <div class="login-form">
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
                    <ul class="dropdown-menu text-small shadow w-100" aria-labelledby="dropdownUser2" style="">
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
