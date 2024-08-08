package org.codegym.users_case_study.service;

import org.codegym.users_case_study.dao.RoleDAO;
import org.codegym.users_case_study.model.Role;

public class RoleService {
    RoleDAO roleDAO = new RoleDAO();
    public Role getRoleByName(String name) {
        return roleDAO.getRole(name);
    }
    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }
}
