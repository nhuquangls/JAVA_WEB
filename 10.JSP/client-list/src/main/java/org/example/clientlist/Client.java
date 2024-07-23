package org.example.clientlist;


public class Client {
    private String name;
    private String birthDay;
    private String address;
    private boolean gender;

    public Client(String name, String birthDay, String address, boolean gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender=" + gender +
                '}';
    }
}
