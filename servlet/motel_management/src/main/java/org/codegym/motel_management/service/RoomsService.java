package org.codegym.motel_management.service;

import jakarta.servlet.http.HttpServletRequest;
import org.codegym.motel_management.dao.RoomsDAO;
import org.codegym.motel_management.model.PaymentType;
import org.codegym.motel_management.model.Room;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RoomsService {
    private final RoomsDAO roomsDAO = new RoomsDAO();
    private final PaymentTypeService paymentTypeService = new PaymentTypeService();

    public List<Room> getAllRooms() {
        return roomsDAO.getAllRooms();
    }

    public void addRoom(HttpServletRequest request) {
        String tenantName = request.getParameter("tenantName");
        String phone = request.getParameter("phone");
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        Date rentalDate = new Date(timestamp.getTime());
        int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
        PaymentType paymentType = paymentTypeService.getPaymentTypeById(paymentTypeId);
        String note = request.getParameter("note");
        roomsDAO.addRoom(new Room(tenantName, phone, rentalDate, paymentType, note));
    }

    public void editRoom(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenantName = request.getParameter("tenantName");
        String phone = request.getParameter("phone");
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        Date rentalDate = new Date(timestamp.getTime());
        int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
        PaymentType paymentType = paymentTypeService.getPaymentTypeById(paymentTypeId);
        String note = request.getParameter("note");
        Room room = new Room(id, tenantName, phone, rentalDate, paymentType, note);
        roomsDAO.editRoom(room);
    }
    public Room getRoomById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
         return roomsDAO.getRoomById(id);
    }
}