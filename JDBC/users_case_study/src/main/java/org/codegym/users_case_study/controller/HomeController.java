package org.codegym.users_case_study.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.codegym.users_case_study.service.PostService;
import org.codegym.users_case_study.service.UserService;

import java.io.IOException;


@WebServlet(urlPatterns = {"/home", "/login", "/register", "/logout", "/search"})
public class HomeController extends HttpServlet {
private UserService userService = new UserService();
private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        if (url == null) url = "";

        switch (url) {
            case "/login":
                request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
                break;
            case "/register":
                request.getRequestDispatcher("/views/login/register.jsp").forward(request, response);
                break;
            case "/logout":
                HttpSession session = request.getSession();
                session.removeAttribute("user");
                break;
            default:
                break;
        }
        request.setAttribute("page", postService.getPostsByPage(request));
        request.setAttribute("posts", postService.getAllPosts());
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getServletPath();
        if (url == null) url = "";

        switch (url) {
            case "/login":
                request.setAttribute("loginStatus", userService.loginStatus(request));
                request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
                break;
            case "/register":
                request.setAttribute("createStatus", userService.createUser(request));
                request.getRequestDispatcher("views/login/register.jsp").forward(request, response);
                break;
            case "/search":
                request.setAttribute("page", postService.getPostsByFind(request));
                request.getRequestDispatcher("/views/home.jsp").forward(request, response);
                break;
            default:

                break;
        }
    }
}
