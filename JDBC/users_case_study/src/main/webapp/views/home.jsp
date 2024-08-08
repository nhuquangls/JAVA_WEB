<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ITruyện</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/src/css/home.css">
</head>
<body>
    <c:import url="/views/includes/header.jsp"/>
    <c:import url="/views/includes/slide-in-menu.jsp"/>
    <c:set var="posts" value="${requestScope.posts}"/>
    <c:set var="page" value="${requestScope.page}"/>
    <div class="main container-fluid pt-5">
        <div class="container-lg">
            <div class="row">
                <div class="col-12 col-lg-10" style="min-height: 100vh">
                    <div class="main-content bg-light h-100 rounded p-5">
                        <button class="btn btn-light mb-5 border border-3 rounded d-lg-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                            <box-icon name='chevrons-right'></box-icon>
                        </button>
                        <div class="hot-content">
                            <c:if test="${param.search==null}"><h4>Truyện hot <box-icon type='solid' name='hot'></box-icon></h4></c:if>
                            <c:if test="${param.search!=null}"><h4>Search: ${param.search}</h4></c:if>
                            <hr>
                            <div class="list-group">
                                <c:forEach var="item" items="${page}">
                                    <a href="/post?action=detail&id=${item.id}" class="d-flex list-group-item list-group-item-action">
                                        <div class="photo col-2 overflow-hidden">
                                            <img src="${item.photo}" alt="photo" width="100%">
                                        </div>
                                        <div class="content col-10 p-3">
                                            <div class="d-flex w-100 justify-content-between">
                                                <h5 class="mb-1">${item.title}</h5>
                                                <small class="text-muted">${item.createDate}</small>
                                            </div>
                                            <p class="mb-1">Người đăng: ${item.user.username}</p>
                                            <small class="text-muted">Lượt xem: ${item.view}</small>
                                        </div>
                                    </a>
                                </c:forEach>
                            </div>
                        </div>
                        <c:set var="extra" value="${(posts.size() % 4) == 0 ? 0 : 1}"/>
                        <c:set var="totalPage" value="${posts.size()/4 + extra}"/>
                        <div class="page d-flex justify-content-end pe-3 gap-2">
                            <c:forEach var="i" begin="1" end="${totalPage}" step="1">
                                <a href="/home?page=${i}" class="text-decoration-none">${i}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>

                <div class="right-content col-2 d-none d-lg-block bg-light rounded pt-4">
                    <h5>New Stories</h5>
                    <div class="list-group">
                        <c:forEach var="item" items="${posts}">
                            <a href="/post?action=detail&id=${item.id}" class="list-group-item list-group-item-action list-group-item-secondary">${item.title}</a>
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
