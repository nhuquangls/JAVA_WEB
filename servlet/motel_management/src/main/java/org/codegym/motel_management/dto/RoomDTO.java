package org.codegym.motel_management.dto;

public class RoomDTO {
    private int id;
    private String tenantName;
    private String phone;
    private String rentalDate;
    private String paymentType;
    private String note;

    public RoomDTO(int id, String tenantName, String phone, String rentalDate, String paymentType, String note) {
        this.id = id;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
