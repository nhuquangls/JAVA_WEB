<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
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
    <form action="/books?action=add" method="post">
        <label><span>Name</span>
            <input type="text" name="name" required>
        </label>
        <label><span>Description</span>
            <textarea name="description" cols="30" rows="5" required></textarea>
        </label>
        <label><span>Price</span>
            <input type="number" name="price" required>
        </label>
        <c:set var="categories" value="${requestScope.categories}"/>
        <label><span>Category</span>
            <select name="category_id">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </label><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
