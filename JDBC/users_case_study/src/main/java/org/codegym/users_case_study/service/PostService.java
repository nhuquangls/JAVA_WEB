package org.codegym.users_case_study.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import org.codegym.users_case_study.dao.PostDAO;
import org.codegym.users_case_study.model.Post;
import org.codegym.users_case_study.model.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;


public class PostService {
    PostDAO postDAO = new PostDAO();

    public void addPost(HttpServletRequest request) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String photo = getPathFromFile(request, "photo");
        postDAO.addPost(new Post(title, content, user, LocalDateTime.now(), photo));
    }

    public Post getPostById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return postDAO.getPostById(id);
    }

    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    public String getPathFromFile(HttpServletRequest request, String param) throws ServletException, IOException {
        String uploadPath = request.getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        Part filePart = request.getPart(param);
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            filePart.write(uploadPath + File.separator + fileName);

            return "uploads/" + fileName;
        }
        return null;
    }


    public List<Post> getPostsByPage(HttpServletRequest request) {
        int quantity = 4;
        int page = 1;
        if (request.getParameter("page")!= null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int offset = (page - 1) * quantity;
        return postDAO.getPostsByPage(quantity, offset);
    }
    public List<Post> getPostsByFind(HttpServletRequest request) {
        String keyWord = request.getParameter("search");
        return postDAO.getPostsByFind(keyWord);
    }

    public void deletePost(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        postDAO.deletePost(id);
    }

    public void updatePost(HttpServletRequest request) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String photo = getPathFromFile(request, "photo");
        int view = Integer.parseInt(request.getParameter("view"));
        postDAO.updatePost(new Post(id, title, content, user, LocalDateTime.now(), photo, view));
    }

    public int getLastPostId() {
        return postDAO.getLastPostId();
    }
}
