package org.codegym.motel_management.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codegym.motel_management.service.PaymentTypeService;
import org.codegym.motel_management.service.RoomsService;

import java.io.IOException;

@WebServlet(urlPatterns = "/motel_rooms")
public class RoomsController extends HttpServlet {
    private RoomsService roomsService = new RoomsService();
    private PaymentTypeService paymentTypeService = new PaymentTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                request.setAttribute("paymentTypes", paymentTypeService.getAllPaymentTypes());
                request.getRequestDispatcher("/views/add.jsp").forward(request, response);
                break;
            case "edit":
                request.setAttribute("paymentTypes", paymentTypeService.getAllPaymentTypes());
                request.setAttribute("room", roomsService.getRoomById(request));
                request.getRequestDispatcher("/views/add.jsp").forward(request, response);
                break;
            default:
                break;
        }
        request.setAttribute("rooms", roomsService.getAllRooms());
        request.getRequestDispatcher("/views/rooms.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                roomsService.addRoom(request);
                response.sendRedirect("/motel_rooms");
                break;
            case "edit":
                roomsService.editRoom(request);
                response.sendRedirect("/motel_rooms");
                break;
            case "delete":
                roomsService.deleteRooms(request);
                response.sendRedirect("/motel_rooms");
                break;
            default:
                break;
        }
    }
}
