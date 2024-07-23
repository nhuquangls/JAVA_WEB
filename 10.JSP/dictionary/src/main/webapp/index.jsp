<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
    <form action="dictionary" method="post">
        <input type="text" name="word" value="${param.word}">
        <input type="submit" value="Seach">
    </form>
    <br>
    <c:if test="${requestScope.value != null}">
        <h3>${requestScope.value}</h3>
    </c:if>
</body>
</html>