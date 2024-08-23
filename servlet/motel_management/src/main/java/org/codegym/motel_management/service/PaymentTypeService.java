package org.codegym.motel_management.service;

import org.codegym.motel_management.dao.PaymentTypeDAO;
import org.codegym.motel_management.model.PaymentType;

import java.util.List;

public class PaymentTypeService {
    private final PaymentTypeDAO paymentTypeDAO = new PaymentTypeDAO();

    public PaymentType getPaymentTypeById(int id) {
        return paymentTypeDAO.getPaymentTypeById(id);
    }
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeDAO.getAllPaymentType();
    }
}
