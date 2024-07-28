package org.codegym.user_management.dao;

import org.codegym.user_management.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers() throws SQLException;

    public void deleteUser(int id) throws SQLException;

    public void updateUser(User user) throws SQLException;
}
