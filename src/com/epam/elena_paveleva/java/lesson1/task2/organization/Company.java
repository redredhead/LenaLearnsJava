package com.epam.elena_paveleva.java.lesson1.task2.organization;

import com.epam.elena_paveleva.java.lesson1.task2.exceptions.IllegalCompanyStateException;

import java.time.LocalDate;

public class Company {
    private final String TIN;
    private String name;
    private String address;
    private boolean active;
    private LocalDate closureDate;

    Company(String TIN, String name, String address) {
        this.TIN = TIN;
        this.name = name;
        this.address = address;
        active = true;
    }

    public void close() {
        if (active) {
            active = false;
            closureDate = LocalDate.now();
            printCompanyInfo();
            System.out.println("Closure date: " + closureDate);
        } else {
            throw new IllegalCompanyStateException("company inactive");
        }
    }

    private void printCompanyInfo() {
        System.out.println("Name: " + name + "\nTIN: " + TIN + "\nAddress:" + address);
    }

    public boolean isActive() {
        return active;
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
