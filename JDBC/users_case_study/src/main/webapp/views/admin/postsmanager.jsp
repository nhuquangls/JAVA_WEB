<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="border-start border-5 border-primary p-2 rounded shadow">
    <span>Total posts: ${posts.size()}</span><br>
</div>
<br>
<div class="post d-flex">
    <div class="id">ID</div>
    <div class="username width-15">Title</div>
    <div class="password width-15">Content</div>
    <div class="role width-15">Poster</div>
    <div class="status width-15">Created Date</div>
</div>
<c:forEach var="item" items="${posts}">
    <div class="post border border-1 p-2 rounded d-flex">
        <div class="id">${item.id}</div>
        <div class="width-15">${item.title}</div>
        <div class="width-15"><div class="content">${item.content}</div></div>
        <div class="width-15">${item.user!=null?item.user.username:'Không xác định'}</div>
        <div class="width-15">${item.createDate}</div>
        <div class="width-15"><a href="/admin?target=posts&action=update&id=${item.id}" class="btn btn-primary">Edit</a></div>
        <div class="width-15">
            <button type="button" onclick="deletePost(${item.id})" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deletePost">
                Delete
            </button>
        </div>
    </div>
</c:forEach>

<div class="modal fade" id="deletePost" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
    function deletePost(id) {
        let confirmDelete = document.getElementById("confirm-delete");
        confirmDelete.href = "/admin?target=posts&action=delete&id=" + id;
        document.getElementById("deleteMessage").innerHTML = "Are you sure to delete this post";
    }
</script>