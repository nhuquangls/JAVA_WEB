<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Motel Rooms</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <c:set var="rooms" value="${requestScope.rooms}"/>
    <div class="container">
        <h3>Motel Manager</h3>

        <form action="/motel_rooms?action=search" method="get"></form>
            <label>
                <input type="text" name="search" placeholder="Search by name...">
            </label>
            <button class="btn btn-primary">submit</button>
        <a href="/motel_rooms?action=add" class="btn btn-warning">Add</a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Room ID</th>
                <th scope="col">Tenant Name</th>
                <th scope="col">Phone</th>
                <th scope="col">Rental Date</th>
                <th scope="col">Payment Type</th>
                <th scope="col">Note</th>
            </tr>
            </thead>
            <tbody>
                <c:set var="count" value="1"/>
                <form id="deleteForm" action="/motel_rooms?action=delete" method="post">
                <c:forEach var="room" items="${rooms}">
                    <tr>
                        <th scope="row">${count}</th>
                        <td>${room.id}</td>
                        <td>${room.tenantName}</td>
                        <td>${room.phone}</td>
                        <td>${room.rentalDate}</td>
                        <td>${room.paymentType}</td>
                        <td>${room.note}</td>
                        <td>
                            <a href="/motel_rooms?action=edit&id=${room.id}" class="btn btn-primary">Edit</a>
                        </td>
                        <td>
                            <label>
                                <input type="checkbox" name="delete" value="${room.id}">
                            </label>
                        </td>
                    </tr>
                </c:forEach>
                </form>
            </tbody>
        </table>
        <div class="d-flex justify-content-end"><button class="btn btn-danger w-10" onclick="submitDeleteForm()">Delete</button></div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script>
    function submitDeleteForm() {
        document.getElementById("deleteForm").submit();
    }
</script>
</html>
