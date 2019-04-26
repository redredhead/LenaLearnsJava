package com.epam.elena_paveleva.java.lesson1.task2.organization;

public class Company {
    private final String TIN;
    private String name;
    private String address;


    Company(String TIN, String name, String address) {
        this.TIN = TIN;
        this.name = name;
        this.address = address;
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
