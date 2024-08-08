package org.codegym.users_case_study.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codegym.users_case_study.service.PostService;

import java.io.IOException;

@MultipartConfig
@WebServlet(urlPatterns = "/post")
public class PostController extends HttpServlet {
    PostService postService = new PostService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "detail":
                request.setAttribute("post", postService.getPostById(request));
                break;
            case "create":
                request.getRequestDispatcher("/views/post/newpost.jsp").forward(request, response);
                break;
            case "update":
                request.setAttribute("post", postService.getPostById(request));
                request.getRequestDispatcher("/views/post/newpost.jsp").forward(request, response);
                break;
            default:
                break;
        }
        request.setAttribute("posts", postService.getAllPosts());
        request.getRequestDispatcher("/views/post/post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                postService.addPost(request);
                int id = postService.getLastPostId();
                response.sendRedirect("/post?action=detail&id=" + id);
                break;
            case "update":
                postService.updatePost(request);
                int postId = Integer.parseInt(request.getParameter("id"));
                response.sendRedirect("/post?action=detail&id=" + postId);
                break;
        }
    }
}
