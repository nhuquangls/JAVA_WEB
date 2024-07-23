<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Client List</title>
    <style>
        table,th,td {
            border: 1px solid;
            border-collapse: collapse;
            padding: 10px 10px;
        }
    </style>
</head>
<body>
<c:set var="clientList" value="${requestScope.clientList}"/>
<table>
    <tr>
        <th colspan="4">Danh Sách Khách Hàng</th>
    </tr>
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
    </tr>
    <c:if test="${clientList != null}">
    <c:forEach var="client" items="${clientList}">
        <tr>
            <td>${client.name}</td>
            <td>${client.birthDay}</td>
            <td>${client.address}</td>
            <td>${client.gender ? 'Male' : 'Female'}</td>
        </tr>
    </c:forEach>
    </c:if>
</table>
</body>
</html>