package org.codegym.users_case_study.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codegym.users_case_study.service.PostService;
import org.codegym.users_case_study.service.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/admin")
public class AdminController extends HttpServlet {
    UserService userService = new UserService();
    PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = request.getParameter("target");
        if (target == null) target = "";
        switch (target) {
            case "users":
                String action = request.getParameter("action");
                if (action==null) action = "";
                if (action.equals("delete")) {
                    userService.deleteUser(request);
                }
                request.setAttribute("users", userService.getAllUsers());
                break;
            case "posts":
                String postAction = request.getParameter("action");
                if (postAction==null) postAction = "";
                if (postAction.equals("delete")) {
                    postService.deletePost(request);
                }
                if (postAction.equals("update")) {
                    request.setAttribute("post", postService.getPostById(request));
                    request.getRequestDispatcher("/views/post/newpost.jsp").forward(request, response);
                }
                request.setAttribute("posts", postService.getAllPosts());
                break;
            default:
                break;
        }
        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String target = request.getParameter("target");
        if (target == null) target = "";
        switch (target) {
            case "users":
                String action = request.getParameter("action");
                if (action == null) action = "";
                if (action.equals("update")) {
                    userService.updateUser(request);
                    response.sendRedirect("/admin?target=users");
                }
                break;
            case "posts":
                break;
            default:
                break;
        }
    }
}
