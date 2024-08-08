package org.codegym.users_case_study.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.codegym.users_case_study.dao.UserDAO;
import org.codegym.users_case_study.model.Role;
import org.codegym.users_case_study.model.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();
    private final RoleService roleService = new RoleService();

    public boolean loginStatus(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            if (!user.getStatus()) {
                request.setAttribute("disabled", true);
                return false;
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return true;
        }
        return false;
    }

    public boolean createUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Role role = roleService.getRoleByName("user");
        User user = new User(username, password, role, true);
        return userDAO.addUser(user);
    }

    public User getUserByName(String username) {
        return userDAO.getUserByUsername(username);
    }
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    public int getTotalUsers() {
        return userDAO.getTotalUsers();
    }
    public void deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(userId);
    }
    public void updateUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role_name = request.getParameter("role");
        Role role = roleService.getRoleByName(role_name);
        boolean status = request.getParameter("status").equals("true");
        userDAO.updateUser(new User(id, username, password, role, status));
    }
}
