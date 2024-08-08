package org.codegym.users_case_study.dao;

import org.codegym.users_case_study.dbconnection.DBConnection;
import org.codegym.users_case_study.model.Post;
import org.codegym.users_case_study.model.User;
import org.codegym.users_case_study.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private static final String SELECT_ALL = "SELECT * FROM posts ORDER BY id DESC";
    private static final String SELECT_BY_ID = "SELECT * FROM posts WHERE id = ?";
    private static final String INSERT_POST = "INSERT INTO posts (title, content, user_id, create_date, photo, view) VALUE (?, ?, ?, ?, ?, 0)";
    private static final String UPDATE_POST = "UPDATE posts SET title = ?, content = ?, user_id = ?, create_date = ?, photo = ?, view = ? WHERE id = ?";
    private static final String DELETE_POST = "DELETE from posts WHERE id = ?";
    private static final String UPDATE_VIEW = "UPDATE posts SET view = ? WHERE id = ?";
    private static final String SELECT_PAGE = "SELECT * FROM posts ORDER BY view DESC limit ? offset ?";
    private static final String SELECT_FIND = "SELECT * FROM posts WHERE title LIKE ?";
    private static final String SELECT_LAST_POST_ID = "SELECT id FROM posts ORDER BY id DESC LIMIT 1";


    UserService userService = new UserService();

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                int user_id = resultSet.getInt("user_id");
                User user = userService.getUserById(user_id);
                LocalDateTime create_date = (LocalDateTime) resultSet.getObject("create_date");
                String photo = resultSet.getString("photo");
                int view = resultSet.getInt("view");
                posts.add(new Post(id, title, content, user, create_date, photo, view));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return posts;
    }

    public void addPost(Post post) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POST)) {
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setInt(3, post.getUser().getId());
            preparedStatement.setObject(4, post.getCreateDate());
            preparedStatement.setString(5, post.getPhoto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Post getPostById(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    User user = userService.getUserById(resultSet.getInt("user_id"));
                    LocalDateTime createDate = (LocalDateTime) resultSet.getObject("create_date");
                    String photo = resultSet.getString("photo");
                    int view = resultSet.getInt("view");
                    int newView = view + 1;
                    updateView(newView, id);
                    return new Post(id, title, content, user, createDate, photo, view);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateView(int newView, int postId) {
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_VIEW)){
            preparedStatement.setInt(1, newView);
            preparedStatement.setInt(2, postId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Post> getPostsByPage(int quantity, int offset) {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAGE)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, offset);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    int user_id = resultSet.getInt("user_id");
                    User user = userService.getUserById(user_id);
                    LocalDateTime create_date = (LocalDateTime) resultSet.getObject("create_date");
                    String photo = resultSet.getString("photo");
                    int view = resultSet.getInt("view");
                    posts.add(new Post(id, title, content, user, create_date, photo, view));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return posts;
    }

    public List<Post> getPostsByFind(String keyWord) {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FIND)) {
            preparedStatement.setString(1, keyWord + '%');
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String content = resultSet.getString("content");
                    int user_id = resultSet.getInt("user_id");
                    User user = userService.getUserById(user_id);
                    LocalDateTime create_date = (LocalDateTime) resultSet.getObject("create_date");
                    String photo = resultSet.getString("photo");
                    int view = resultSet.getInt("view");
                    posts.add(new Post(id, title, content, user, create_date, photo, view));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return posts;
    }

    public void deletePost(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_POST)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePost(Post post) {
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POST)){
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setInt(3, post.getUser().getId());
            preparedStatement.setObject(4, post.getCreateDate());
            preparedStatement.setString(5, post.getPhoto());
            preparedStatement.setInt(6, post.getView());
            preparedStatement.setInt(7, post.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public int getLastPostId() {
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_POST_ID);
            ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
