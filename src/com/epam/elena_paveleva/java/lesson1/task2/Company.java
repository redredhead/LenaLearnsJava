package com.epam.elena_paveleva.java.lesson1.task2;

public class Company {
    private final String TIN;
    private String name = null;
    private String address = null;

    Company(String TIN, String name, String address) {
        this.TIN = TIN;
        this.name = name;
        this.address = address;
    }
    Company() { // убрать
        this.TIN = null;
    }

    public boolean isActive() {
        return (TIN != null && name != null && address != null);
    }

    public String getName() {
        return name;
    }

    public String getTIN() {
        return TIN;
    }

    public String getAddress() {
        return address;
    }

}
