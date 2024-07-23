package org.example.clientlist;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = "/list-client")
public class ClientListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ClientList clientList = new ClientList();
        request.setAttribute("clientList", clientList.getList());
        request.getRequestDispatcher("client.jsp").forward(request, response);
    }

    public void destroy() {
    }
}