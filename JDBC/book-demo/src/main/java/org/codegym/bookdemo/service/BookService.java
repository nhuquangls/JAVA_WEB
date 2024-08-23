package org.codegym.bookdemo.service;

import jakarta.servlet.http.HttpServletRequest;
import org.codegym.bookdemo.dao.BookDAO;
import org.codegym.bookdemo.dao.CategoryDAO;
import org.codegym.bookdemo.dto.BookDTO;
import org.codegym.bookdemo.model.Book;
import org.codegym.bookdemo.model.Category;

import java.util.List;

public class BookService {
    private BookDAO bookDAO = new BookDAO();
    private CategoryService categoryService = new CategoryService();

    public List<BookDTO> getAllBooks() {
        return bookDAO.getAllBooks();
    }
    public BookDTO getBookById(int id) {
        return bookDAO.getOneBook(id);
    }

    public void addBook(HttpServletRequest request) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Category category = categoryService.getOneCategory(category_id);
        bookDAO.addBook(new Book(name, description, price, category));
    }

    public void editBook(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        Category category = categoryService.getOneCategory(category_id);
        bookDAO.updateBook(new Book(id, name, description, price, category));
    }

    public void deleteBook(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.deleteBook(id);
    }

    public List<BookDTO> getBooksByPage(HttpServletRequest request) {
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int quantity = 3;
        int offset = (page - 1) * quantity;
        return bookDAO.getBooksByPage(quantity, offset);
    }

    public int getTotalRecord() {
        return bookDAO.getTotalRecord();
    }

    public int getTotalPage() {
        int totalRecord = getTotalRecord();
        int extra = 0;
        if (totalRecord % 3 != 0) extra = 1;
        return totalRecord / 3 + extra;
    }
}
