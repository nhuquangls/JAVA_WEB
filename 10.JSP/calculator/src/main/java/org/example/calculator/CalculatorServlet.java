package org.example.calculator;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String strNumber1 = request.getParameter("number1");
        String strNumber2 = request.getParameter("number2");
        String operator = request.getParameter("operator");
        String result = "";
        try {
            double number1 = Double.parseDouble(strNumber1);
            double number2 = Double.parseDouble(strNumber2);
            switch (operator) {
                case "+":
                    result = "" + (number1 + number2);
                    break;
                case "-":
                    result = "" + (number1 - number2);
                    break;
                case "x":
                    result = "" + (number1 * number2);
                    break;
                case "/":
                    if (number2 == 0) {
                        result = "Cannot be divided by zero";
                        break;
                    }
                    result = "" + (number1 / number2);
                    break;
            }
        } catch (NumberFormatException e) {
            result = "Invalid Input!";
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    public void destroy() {
    }
}