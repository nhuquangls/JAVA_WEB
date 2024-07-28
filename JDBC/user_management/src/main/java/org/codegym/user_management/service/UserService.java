package org.codegym.user_management.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codegym.user_management.dao.UserDAO;
import org.codegym.user_management.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public List<User> getAllUsers() {
        return userDAO.selectAllUsers();
    }
    public void insertUser(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        userDAO.insertUser(new User(0, name, email, country));
    }

    public void deleteUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
    }

    public void updateUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        userDAO.updateUser(new User(id, name, email, country));
    }

    public User getUserById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return userDAO.selectUser(id);
    }

    public List<User> sortUsersByField(HttpServletRequest request) {
        String field = request.getParameter("field");
        String type = request.getParameter("type");
        return userDAO.sortUsersByField(field, type);
    }
}
