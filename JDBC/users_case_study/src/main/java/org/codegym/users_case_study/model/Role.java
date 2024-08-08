package org.codegym.users_case_study.model;

public class Role {
    int id;
    String role_name;

    public Role(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
