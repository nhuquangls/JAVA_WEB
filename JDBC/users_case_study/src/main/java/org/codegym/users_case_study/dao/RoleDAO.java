package org.codegym.users_case_study.dao;

import org.codegym.users_case_study.dbconnection.DBConnection;
import org.codegym.users_case_study.model.Role;
import org.codegym.users_case_study.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDAO {
    private static final String SELECT_ALL = "SELECT * FROM role";
    private static final String INSERT_ROLE = "INSERT INTO role (role_name) VALUE (?)";
    private static final String UPDATE_ROLE = "UPDATE role SET role_name = ? WHERE id = ?";
    private static final String DELETE_ROLE = "DELETE from role WHERE id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM role WHERE role_name = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM role WHERE id = ?";


    public List<Role> getAllRoles() {
        return null;
    }

    public void addRole(Role user) {

    }
    public void updateRole(Role user) {

    }

    public void deleteRole(int roleId) {

    }

    public Role getRole(String name) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME)) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int role_id = resultSet.getInt("id");
                    return new Role(role_id, name);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Role getRoleById(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String role_name = resultSet.getString("role_name");
                    return new Role(id, role_name);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
