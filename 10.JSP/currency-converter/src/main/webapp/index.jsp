<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Currency Converter</h2>
    <form action="converter" method="post">
        <label>
            <select name="firstCurrency">
                <option value="25000" <c:if test="${param.firstCurrency == '25000'}"> selected </c:if>>USD</option>
                <option value="1" <c:if test="${param.firstCurrency == '1'}"> selected </c:if>>VND</option>
            </select>
        </label>
        To
        <label>
            <select name="secondCurrency">
                <option value="1" <c:if test="${param.secondCurrency == '1'}"> selected </c:if>>VND</option>
                <option value="25000" <c:if test="${param.secondCurrency == '25000'}"> selected </c:if>>USD</option>
            </select>
        </label><br>
        <label>Amount: <input type="number" name="amount"></label><br>
        <input type="submit" value="Converter">
    </form>


    <c:set var="firstCurrency" value="${requestScope.firstCurrency.equals('1') ? 'VND' : 'USD'}" />
    <c:set var="secondCurrency" value="${requestScope.seconCurrency.equals('25000') ? 'USD' : 'VND'}" />
    <c:set var="amount" value="${param.amount}"/>
    <c:if test="${requestScope.result != null}">
        <h3>Result: ${amount} ${firstCurrency} = ${requestScope.result} ${secondCurrency} </h3>
    </c:if>
</body>
</html>