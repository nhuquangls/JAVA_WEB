package org.codegym.user_management.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codegym.user_management.service.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/user-list")
public class UserController extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        String requestToView = "";
        switch (action) {
            case "add":
                requestToView = "add";
                break;
            case "edit":
                requestToView = "edit";
                break;
            case "sort":
                request.setAttribute("users", userService.sortUsersByField(request));
                request.getRequestDispatcher("/view/list.jsp").forward(request, response);
                break;
            default:
                break;
        }
        request.setAttribute("requestToView", requestToView);
        request.setAttribute("users", userService.getAllUsers());
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                userService.insertUser(request);
                break;
            case "delete":
                userService.deleteUser(request);
                break;
            case "edit":
                userService.updateUser(request);
                break;
            case "sort":
                break;
        }
        response.sendRedirect("/user-list");
    }
}
