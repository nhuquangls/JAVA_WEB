<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
    <style>
        #editor-container{
            height: 500px;
        }
        .ql-editor img {
            max-width: 50%;
            height: auto;
        }
    </style>
</head>
<body>
    <c:set var="post" value="${requestScope.post}"/>
    <div class="container mt-5">
        <h1>New Post</h1>
        <form method="post" action="${post==null?'/post?action=create':'/post?action=update'}" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" id="title" placeholder="Truyện abcxyz" name="title" value="${post.title}">
            </div>
            <div class="mb-3">
                <label for="formFile" class="form-label">Photo</label>
                <input class="form-control" type="file" id="formFile" name="photo">
            </div>
            <div class="mb-3">
                <div id="editor-container">
                    ${post.content}
                </div>
                <textarea id="hidden-textarea" name="content" style="display:none;"></textarea>
            </div>
            <button type="submit" class="btn btn-primary" onclick="updateTextarea()">Submit</button>
            <a href="/home" class="btn btn-danger">Cancel</a>
            <c:if test="${post!=null}">
                <input type="hidden" name="id" value="${post.id}">
                <input type="hidden" name="view" value="${post.view}">
            </c:if>
        </form>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
<script>
    var quill = new Quill('#editor-container', {
        theme: 'snow',
        modules: {
            toolbar: [
                [{ 'header': [1, 2, false] }],
                ['bold', 'italic', 'underline'],
                [{ 'list': 'ordered'}, { 'list': 'bullet' }],
                ['link', 'image']
            ]
        }
    });
    function updateTextarea() {
        var hiddenTextarea = document.getElementById('hidden-textarea');
        hiddenTextarea.value = quill.root.innerHTML;
    }
</script>
</html>
