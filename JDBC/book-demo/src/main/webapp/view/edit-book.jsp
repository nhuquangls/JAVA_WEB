<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
    <style>
        form {
            display: flex;
            flex-direction: column;

        }
        form label {
            display: flex;
            align-items: start;
            margin-top: 10px;
        }
        form span {
            font-weight: bold;
            width: 150px;
        }
        form button {
            width: 60px;
        }

    </style>
</head>
<body>
<c:set var="book" value="${requestScope.books}"/>
<c:set var="categories" value="${requestScope.categories}"/>

<form action="/books?action=edit" method="post">
    <input type="hidden" name="id" value="${book.id}">
    <label><span>Name</span>
        <input type="text" name="name" required value="${book.name}">
    </label>
    <label><span>Description</span>
        <textarea name="description" cols="30" rows="5" required>${book.description}</textarea>
    </label>
    <label><span>Price</span>
        <input type="number" name="price" required value="${book.price}">
    </label>
    <label><span>Category</span>
        <select name="category_id">
            <c:forEach var="cat" items="${categories}">
                <option value="${cat.id}" <c:if test="${cat.id == book.category.id}">selected</c:if>>${cat.name}</option>
            </c:forEach>
        </select>
    </label><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
