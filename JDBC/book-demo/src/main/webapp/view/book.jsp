<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
    <style>
        table {
            width: 100%;
            border: 1px solid;
            padding: 10px;
        }
        th, td {
            text-align: start;
            width: 200px;
        }
    </style>
</head>
<body>
    <h1>Books</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Category</th>
        </tr>
        <c:forEach var="book" items="${requestScope.books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.description}</td>
                <td>${book.price}</td>
                <td>${book.category.name == null? 'Khong xac dinh' : book.category.name}</td>
                <td><a href="/books?action=edit&id=${book.id}"><button>Edit</button></a></td>
                <td><a href="/books?action=delete&id=${book.id}"><button>Delete</button></a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <a href="books?action=add"><Button>Create new book</Button></a>
    <a href="books/category"><Button>Category management</Button></a>
    <c:forEach var="i" begin="1" end="10" step="1">
        <a href="books?page=${i}"><button>${i}</button></a>
    </c:forEach>
</body>
</html>
