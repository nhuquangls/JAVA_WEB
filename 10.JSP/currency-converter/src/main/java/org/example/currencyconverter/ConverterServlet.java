package org.example.currencyconverter;

import java.io.*;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = "/converter")
public class ConverterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstCurrency = request.getParameter("firstCurrency");
        String secondCurrency = request.getParameter("secondCurrency");
        String amount = request.getParameter("amount");
        if (amount.isEmpty()) amount = "0";
        double result = CurrencyConverter.Converter(firstCurrency, secondCurrency, amount);
        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}