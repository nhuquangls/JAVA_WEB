package org.codegym.bookdemo.service;

import jakarta.servlet.http.HttpServletRequest;
import org.codegym.bookdemo.dao.CategoryDAO;
import org.codegym.bookdemo.model.Category;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
    public Category getOneCategory(int id) {
        return categoryDAO.getOneCategory(id);
    }
    public void addCategory(HttpServletRequest request) {
        String category_name = request.getParameter("category_name");
        categoryDAO.addCategory(new Category(category_name));
    }

    public void updateCategory(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("category_id"));
        String name = request.getParameter("category_name");
        categoryDAO.updateCategory(new Category(id, name));
    }
    public void deleteCategory(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDAO.deleteCategory(id);
    }

}
