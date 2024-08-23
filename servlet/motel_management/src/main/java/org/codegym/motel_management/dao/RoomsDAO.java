package org.codegym.motel_management.dao;

import org.codegym.motel_management.model.PaymentType;
import org.codegym.motel_management.model.Room;
import org.codegym.motel_management.service.PaymentTypeService;
import org.codegym.motel_management.utils.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO {
    private static final String SELECT_ALL = "SELECT * FROM motel_rooms";
    private static final String SELECT_BY_ID = "SELECT * FROM motel_rooms WHERE id = ?";
    private static final String INSERT_ROOM = "INSERT INTO motel_rooms (tenantName, phone, rentalDate, payment_type_id, note) VALUE (?, ?, ?, ?, ?)";
    private static final String UPDARE_ROOM = "UPDATE motel_rooms SET tenantName = ?, phone = ?, rentalDate = ?, payment_type_id = ?, note = ? WHERE id = ?";
    PaymentTypeService paymentTypeService = new PaymentTypeService();


    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenantName = resultSet.getString("tenantName");
                String phone = resultSet.getString("phone");
                Date rentalDate = (Date) resultSet.getObject("rentalDate");
                int paymentTypeId = resultSet.getInt("payment_type_id");
                PaymentType paymentType = paymentTypeService.getPaymentTypeById(paymentTypeId);
                String note = resultSet.getString("note");
                rooms.add(new Room(id, tenantName, phone, rentalDate, paymentType, note));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rooms;
    }

    public void addRoom(Room room) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM)) {
            preparedStatement.setString(1, room.getTenantName());
            preparedStatement.setString(2, room.getPhone());
            preparedStatement.setObject(3, room.getRentalDate());
            preparedStatement.setInt(4, room.getPaymentType().getId());
            preparedStatement.setString(5, room.getNote());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Room getRoomById(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String tenantName = resultSet.getString("tenantName");
                    String phone = resultSet.getString("phone");
                    Date rentalDate = (Date) resultSet.getObject("rentalDate");
                    int paymentTypeId = resultSet.getInt("payment_type_id");
                    PaymentType paymentType = paymentTypeService.getPaymentTypeById(paymentTypeId);
                    String note = resultSet.getString("note");
                    return new Room(id, tenantName, phone, rentalDate, paymentType, note);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void editRoom(Room room) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDARE_ROOM)){
            preparedStatement.setString(1, room.getTenantName());
            preparedStatement.setString(2, room.getPhone());
            preparedStatement.setObject(3, room.getRentalDate());
            preparedStatement.setInt(4, room.getPaymentType().getId());
            preparedStatement.setString(5, room.getNote());
            preparedStatement.setInt(6, room.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
