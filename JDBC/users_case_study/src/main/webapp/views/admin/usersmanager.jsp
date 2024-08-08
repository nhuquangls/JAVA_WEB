<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="border-start border-5 border-primary p-2 rounded shadow">
    <span>Total users: ${users.size()}</span><br>
</div>
<br>
<div class="user d-flex">
    <div class="id">ID</div>
    <div class="username width-15">Username</div>
    <div class="password width-15">Password</div>
    <div class="role width-15">Role</div>
    <div class="status width-15">Status</div>
</div>
<c:forEach var="item" items="${users}">
    <c:if test="${param.editId != item.id}">
        <div class="user border border-1 p-2 rounded d-flex">
            <div class="id">${item.id}</div>
            <div class="username width-15">${item.username}</div>
            <div class="password width-15">${item.password}</div>
            <div class="role width-15">${item.role.role_name}</div>
            <div class="status width-15">${item.status?'Active':'Disabled'}</div>
            <c:if test="${item.role.id!=1}">
                <div class="width-15"><a href="/admin?target=users&action=update&editId=${item.id}" class="btn btn-primary">Edit</a></div>
                <div class="width-15">
                    <button type="button" onclick="deleteUser(${item.id},'${item.username}')" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                        Delete
                    </button>
                </div>
            </c:if>
        </div>
    </c:if>

    <c:if test="${param.editId == item.id}">
        <form action="/admin?target=users&action=update" method="post" class="user border border-1 p-2 rounded d-flex">
            <div class="id">${item.id}</div>
            <div class="username width-15">${item.username}</div>
            <label class="width-15">
                <input type="text" name="password" minlength="4" maxlength="16" value="${item.password}">
            </label>
            <label class="width-15">
                <select name="role"><option value="user">user</option></select>
            </label>
            <label class="width-15">
                <select name="status">
                    <option value="true" ${item.status?'selected':''}>Active</option>
                    <option value="false" ${!item.status?'selected':''}>Disable</option>
                </select>
            </label>
            <input type="hidden" name="id" value="${item.id}">
            <input type="hidden" name="username" value="${item.username}">
            <div class="width-15"><button type="submit" class="btn btn-primary">Save</button></div>
            <div class="width-15"><a href="/admin?target=users" class="btn btn-secondary">Cancel</a></div>
        </form>
    </c:if>
</c:forEach>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Confirm</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <span id="deleteMessage"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <a href="#" class="btn btn-primary" id="confirm-delete">Confirm</a>
            </div>
        </div>
    </div>
</div>
<script>
    function deleteUser(id, name) {
        let confirmDelete = document.getElementById("confirm-delete");
        confirmDelete.href = "/admin?target=users&action=delete&id=" + id;
        document.getElementById("deleteMessage").innerHTML = "Are you sure to delete " + name + "?";
    }
</script>