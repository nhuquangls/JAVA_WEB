package org.codegym.motel_management.dao;

import org.codegym.motel_management.model.PaymentType;
import org.codegym.motel_management.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDAO {
    private static final String SELECT_ALL = "SELECT * FROM payment_type";
    private static final String SELECT_ONE = "SELECT * FROM payment_type WHERE id = ?";

    public List<PaymentType> getAllPaymentType() {
        List<PaymentType> paymentTypes = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("paymentType");
                paymentTypes.add(new PaymentType(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paymentTypes;
    }

    public PaymentType getPaymentTypeById(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("paymentType");
                    return new PaymentType(id, name);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
