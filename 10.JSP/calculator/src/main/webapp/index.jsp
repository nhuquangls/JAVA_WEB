<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h3>Calculator</h3>
    <table>
        <tr>
            <td>
                <form action="calculator" method="post">
                    <input type="text" name="number1" value="${param.number1}">
                    <select name="operator">
                        <option value="+" <c:if test="${param.operator.equals('+')}">selected</c:if> >+</option>
                        <option value="-" <c:if test="${param.operator.equals('-')}">selected</c:if> >-</option>
                        <option value="x" <c:if test="${param.operator.equals('x')}">selected</c:if> >x</option>
                        <option value="/" <c:if test="${param.operator.equals('/')}">selected</c:if> >/</option>
                        <input type="text" name="number2" value="${param.number2}">
                        <button type="submit">=</button>
                    </select>
                </form>
            </td>
            <td>${requestScope.result}</td>
        </tr>

    </table>
</body>
</html>