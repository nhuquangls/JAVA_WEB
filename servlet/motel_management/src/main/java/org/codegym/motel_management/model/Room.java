package org.codegym.motel_management.model;

import java.time.LocalDate;

public class Room {
    private int id;
    private String tenantName;
    private String phone;
    private LocalDate rentalDate;
    private PaymentType paymentType;
    private String note;

    public Room(int id, String tenantName, String phone, LocalDate rentalDate, PaymentType paymentType, String note) {
        this.id = id;
        this.tenantName = tenantName;
        this.phone = phone;
        this.rentalDate = rentalDate;
        this.paymentType = paymentType;
        this.note = note;
    }
    public Room(String tenantName, String phone, LocalDate rentalDate, PaymentType paymentType, String note) {
        this.tenantName = tenantName;
        this.phone = phone;
        this.rentalDate = rentalDate;
        this.paymentType = paymentType;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
