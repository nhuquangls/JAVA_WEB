<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${param.action=='detail'?requestScope.post.title:'Post'}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/src/css/post.css">
</head>
<body>
    <c:import url="/views/includes/header.jsp"/>
    <c:import url="/views/includes/slide-in-menu.jsp"/>
    <c:set var="post" value="${requestScope.post}"/>
    <c:set var="posts" value="${requestScope.posts}"/>
    <div class="main container-fluid pt-5">
        <div class="container-lg">
            <div class="row">
                <div class="col-12 col-lg-10">
                    <div class="main-content bg-light h-100 rounded p-5">
                        <div class="d-flex justify-content-between">
                            <button class="btn btn-light mb-5 border border-3 rounded" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                                <box-icon name='chevrons-right'></box-icon>
                            </button>
                            <c:if test="${sessionScope.user.username=='admin' || sessionScope.user.username == post.user.username}">
                                <a href="/post?action=update&id=${post.id}"><box-icon type='solid' name='edit'></box-icon></a>
                            </c:if>
                        </div>
                        <div class="row">
                            <div class="photo col-4 ms-5 p-0"><img src="${post.photo}" alt="description photo"></div>
                            <div class="info col-5">
                                <h1>${post.title}</h1>
                                <p>Người đăng: ${post.user.username}</p>
                                <p>Ngày: ${post.createDate}</p>
                                <p>Lượt xem: ${post.view}
                            </div>
                        </div>
                        <div class="row">
                            <div class="content col-12 p-5 h-100">
                                ${post.content}
                            </div>
                        </div>
                    </div>
                </div>

                <div class="right-content col-2 d-none d-lg-block bg-light rounded pt-4">
                    <h5>All Stories</h5>
                    <div class="list-group">
                        <c:forEach var="item" items="${posts}">
                            <a href="/post?action=detail&id=${item.id}" class="m-0 row list-group-item list-group-item-action list-group-item-secondary">${item.title}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="/views/includes/footer.jsp"></c:import>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
</html>
