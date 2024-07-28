<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <c:set var="requestToView" value="${requestScope.requestToView}"/>
    <c:set var="users" value="${requestScope.users}"/>
    <div class="d-flex">
        <a href="/user-list?action=add"><button class="btn btn-primary me-5">Add</button></a>

        <div class="add-form" style="${requestToView.equals('add')?'display:block':'display:none'}">
            <form action="/user-list?action=add" method="post" class="m-0">
                <input type="text" name="name" placeholder="name" required>
                <input type="text" name="email" placeholder="email" required>
                <input type="text" name="country" placeholder="country" required>
                <input type="submit" value="Enter" class="btn btn-primary">
                <a href="/user-list"><div class="btn btn-danger">Cancel</div></a>
            </form>
        </div>
        <div class="edit-form" style="${requestToView.equals('edit')?'display:block':'display:none'}">
            <form action="/user-list?action=edit" method="post" class="m-0">
                <input type="hidden" name="id" value="${param.id}">
                <input type="text" name="name" placeholder="name" required value="${param.name}">
                <input type="text" name="email" placeholder="email" required value="${param.email}">
                <input type="text" name="country" placeholder="country" required value="${param.country}">
                <input type="submit" value="Enter" class="btn btn-primary">
                <a href="/user-list"><div class="btn btn-danger">Cancel</div></a>
            </form>
        </div>

    </div>



    <table class="table">
        <thead>
            <tr>
                <c:set var="field" value="${param.field}"/>
                <c:set var="type" value="${param.type.equals('asc')?'desc':'asc'}"/>
                <th scope="col"><a href="/user-list?action=sort&field=id&type=${field.equals('id')?type:'asc'}">ID↑↓</a></th>
                <th scope="col"><a href="/user-list?action=sort&field=name&type=${field.equals('name')?type:'asc'}">Name↑↓</a></th>
                <th scope="col"><a href="/user-list?action=sort&field=email&type=${field.equals('email')?type:'asc'}">Email↑↓</a></th>
                <th scope="col"><a href="/user-list?action=sort&field=country&type=${field.equals('country')?type:'asc'}">Country↑↓</a></th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${users != null}">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <th scope="row">${user.id}</th>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.country}</td>
                        <td>
                            <form action="/user-list" method="get">
                                <input type="hidden" name="action" value="edit">
                                <input type="hidden" name="id" value="${user.id}">
                                <input type="hidden" name="name" value="${user.name}">
                                <input type="hidden" name="email" value="${user.email}">
                                <input type="hidden" name="country" value="${user.country}">
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </form>
                        </td>
                        <td>
                            <form action="/user-list" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="${user.id}">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>

    </table>



    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
