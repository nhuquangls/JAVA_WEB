package org.codegym.bookdemo.dao;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import org.codegym.bookdemo.dbconnection.DBConnection;
import org.codegym.bookdemo.dto.BookDTO;
import org.codegym.bookdemo.model.Book;
import org.codegym.bookdemo.model.Category;
import org.codegym.bookdemo.service.CategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static final String SELECT_ALL = "SELECT * FROM book";
    private static final String SELECT_ONE = "select * from book WHERE id = ?";
    private static final String INSERT_BOOK = "INSERT INTO book (name, description, price, category_id) VALUE (?,?,?,?)";
    private static final String UPDATE_BOOK = "UPDATE book SET name = ?, description = ?, price = ?, category_id = ? WHERE id = ?";
    private static final String DELETE_BOOK = "DELETE FROM book WHERE id = ?";
    private static final String SELECT_PAGE = "SELECT * FROM book LIMIT ? OFFSET ?";
    private static final String SELECT_TOTAL = "SELECT COUNT(*) as count FROM book";
    private CategoryService categoryService = new CategoryService();

    public List<BookDTO> getAllBooks() {
        List<BookDTO> books = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int category_id = resultSet.getInt("category_id");
                String category_name = categoryService.getOneCategory(category_id).getName();
                books.add(new BookDTO(id, name, description, price, category_name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    public BookDTO getOneBook(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    int price = resultSet.getInt("price");
                    String category_name = null;
                    int category_id = 0;
                    try {
                        category_id = Integer.parseInt(resultSet.getString("category_id"));
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    if (category_id != 0) category_name = categoryService.getOneCategory(category_id).getName();
                    return new BookDTO(id, name, description, price, category_name);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void addBook(Book book) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getDescription());
            preparedStatement.setInt(3, book.getPrice());
            preparedStatement.setInt(4, book.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBook(Book book) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getDescription());
            preparedStatement.setInt(3, book.getPrice());
            preparedStatement.setInt(4, book.getCategory().getId());
            preparedStatement.setInt(5, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<BookDTO> getBooksByPage(int quantity, int offset) {
        List<BookDTO> books = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAGE)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int category_id = resultSet.getInt("category_id");
                String category_name = categoryService.getOneCategory(category_id).getName();
                books.add(new BookDTO(id, name, description, price, category_name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
    public int getTotalRecord() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TOTAL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
