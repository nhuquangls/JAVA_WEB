package org.codegym.bookdemo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codegym.bookdemo.service.CategoryService;

import java.io.IOException;

@WebServlet(urlPatterns = "/books/category")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                request.setAttribute("adding", true);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("category", categoryService.getOneCategory(id));
                request.setAttribute("editing", true);
                break;
            case "delete":
                categoryService.deleteCategory(request);
                break;
            default:

                break;
        }
        request.setAttribute("categories",categoryService.getAllCategories());
        request.getRequestDispatcher("/view/category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                categoryService.addCategory(request);
                response.sendRedirect("/books/category");
                break;
            case "edit":
                categoryService.updateCategory(request);
                response.sendRedirect("/books/category");
                break;
            default:

                break;
        }
    }
}
