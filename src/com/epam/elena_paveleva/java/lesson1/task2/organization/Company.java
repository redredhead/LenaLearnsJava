package com.epam.elena_paveleva.java.lesson1.task2.organization;

import com.epam.elena_paveleva.java.lesson1.task2.exceptions.IllegalStateException;

public class Company {
    private final String TIN;
    private String name;
    private String address;
    private boolean Active;


    Company(String TIN, String name, String address) {
        this.TIN = TIN;
        this.name = name;
        this.address = address;
    }

    public void close() throws IllegalStateException {
        if (Active == true) {
            Active = false;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isActive() {
        return Active;
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
