<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
    <style>
        table {
            width: 300px;
            border: 1px solid;
        }
        th, td {
            text-align: start;
        }
        .new-cat-form {
            display: flex;
            gap: 10px;
        }
    </style>
</head>
<body>
    <c:set var="categories" value="${requestScope.categories}"/>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td><a href="/books/category?action=edit&id=${category.id}"><button>Edit</button></a></td>
                <td><a href="/books/category?action=delete&id=${category.id}"><button>Delete</button></a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div class="new-cat-form">
    <a href="/books"><button>Back</button></a>
        <a href="/books/category?action=add"><button>New Category</button></a>
        <c:if test="${requestScope.adding == true}">
            <form action="/books/category?action=add" method="post">
                <label><input type="text" name="category_name" placeholder="category name"></label>
                <button type="submit">Submit</button>
            </form>
        </c:if>
        <c:if test="${requestScope.editing == true}">
            <form action="/books/category?action=edit" method="post">
                <input type="hidden" name="category_id" value="${requestScope.category.id}">
                <label><input type="text" name="category_name" placeholder="category name" value="${requestScope.category.name}"></label>
                <button type="submit">Submit</button>
            </form>
        </c:if>
    </div>
</body>
</html>
