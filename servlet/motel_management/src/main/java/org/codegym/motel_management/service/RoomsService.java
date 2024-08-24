package org.codegym.motel_management.service;

import jakarta.servlet.http.HttpServletRequest;
import org.codegym.motel_management.dao.RoomsDAO;
import org.codegym.motel_management.dto.RoomDTO;
import org.codegym.motel_management.model.PaymentType;
import org.codegym.motel_management.model.Room;
import org.codegym.motel_management.utils.StringDateSwap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomsService {
    private final RoomsDAO roomsDAO = new RoomsDAO();
    private final PaymentTypeService paymentTypeService = new PaymentTypeService();

    public List<RoomDTO> getAllRooms() {
        List<Room> rooms = roomsDAO.getAllRooms();
        List<RoomDTO> dtoList = new ArrayList<>();
        for (Room room : rooms) {
            int id = room.getId();
            String tenantName = room.getTenantName();
            String phone = room.getPhone();
            String rentalDate = StringDateSwap.localDateToString(room.getRentalDate());
            String paymentType = room.getPaymentType().getName();
            String note = room.getNote();
            System.out.println(rentalDate);
            dtoList.add(new RoomDTO(id, tenantName, phone, rentalDate, paymentType, note));
        }
        return dtoList;
    }

    public void addRoom(HttpServletRequest request) {
        String tenantName = request.getParameter("tenantName");
        String phone = request.getParameter("phone");
        String stringDate = request.getParameter("rentalDate");
        LocalDate rentalDate = StringDateSwap.stringToLocalDate(stringDate);
        int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
        PaymentType paymentType = paymentTypeService.getPaymentTypeById(paymentTypeId);
        String note = request.getParameter("note");
        roomsDAO.addRoom(new Room(tenantName, phone, rentalDate, paymentType, note));
    }

    public void editRoom(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenantName = request.getParameter("tenantName");
        String phone = request.getParameter("phone");
        String stringDate = request.getParameter("rentalDate");
        LocalDate rentalDate = StringDateSwap.stringToLocalDate(stringDate);
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

    public void deleteRooms(HttpServletRequest request) {
        String[] listId = request.getParameterValues("delete");
        for (String strId : listId) {
            System.out.println(strId);
            int id = Integer.parseInt(strId);
            roomsDAO.deleteRoom(id);
        }
    }
}