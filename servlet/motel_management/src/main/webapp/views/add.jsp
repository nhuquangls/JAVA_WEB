<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Motel Room</title>
    <style>
        label {
            display: flex;
        }
        span {
            width: 200px;
        }
    </style>
</head>
<body>
    <c:set var="room" value="${requestScope.room}"/>
    <div class="container">
        <h3>Tạo thông tin thuê trọ</h3>
        <form action="${room==null?'/motel_rooms?action=add':'/motel_rooms?action=edit'}" method="post">
            <input type="hidden" name="id" value="${room.id}">
            <label>
                <span>Tên người thuê</span>
                <input type="text" name="tenantName" required value="${room.tenantName}" pattern="[A-Za-z]{5,50}" title="5-50 Ký tự chữ cái">
            </label><br>
            <label>
                <span>Số điện thoại</span>
                <input type="number" name="phone" required value="${room.phone}" minlength="10" maxlength="10">
            </label><br>
            <label>
                <span>Ngày thuê</span>
                <input type="date" name="rentalDate" required value="${room.rentalDate}">
            </label><br>
            <label>
                <span>Hình thức thanh toán</span>
                <select name="paymentTypeId">
                    <c:forEach var="paymentType" items="${requestScope.paymentTypes}">
                        <option value="${paymentType.id}">${paymentType.name}</option>
                    </c:forEach>
                </select>
            </label><br>
            <label>
                <span>Ghi chú</span>
                <textarea name="note" cols="30" rows="10" maxlength="200">${room.note}</textarea>
            </label>
            <button type="submit">Submit</button>
            <br>
        </form>
        <a href="/motel_rooms"><button>Back</button></a>
    </div>
</body>
</html>
