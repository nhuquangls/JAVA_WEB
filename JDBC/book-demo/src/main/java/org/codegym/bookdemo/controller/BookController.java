package org.codegym.bookdemo.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codegym.bookdemo.service.BookService;
import org.codegym.bookdemo.service.CategoryService;

import java.io.IOException;


@WebServlet(urlPatterns = "/books")
public class BookController extends HttpServlet {
    BookService bookService = new BookService();
    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                request.setAttribute("categories", categoryService.getAllCategories());
                request.getRequestDispatcher("view/add-book.jsp").forward(request, response);
                break;
            case "edit":
                int book_id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("books", bookService.getBookById(book_id));
                request.setAttribute("categories", categoryService.getAllCategories());
                request.getRequestDispatcher("view/edit-book.jsp").forward(request, response);
                break;
            case "delete":
                bookService.deleteBook(request);
                response.sendRedirect("/books");
                break;
            default:
                break;
        }
        request.setAttribute("total", bookService.getTotalPage());
        request.setAttribute("books", bookService.getBooksByPage(request));
        request.getRequestDispatcher("view/book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                bookService.addBook(request);
                response.sendRedirect("/books");
                break;
            case "edit":
                bookService.editBook(request);
                response.sendRedirect("/books");
                break;
            default:

                break;
        }
    }
}
