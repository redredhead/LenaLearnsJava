package com.epam.elena_paveleva.java.lesson1.task2;

import java.time.DateTimeException;
import java.time.LocalDate;

public abstract class Vehicle {
    private LocalDate datePurchased;
    LocalDate dateExpired;
    protected int lifetime; //years
    private boolean inUse;

    {
        datePurchased = LocalDate.now();
        inUse = true;
    }

    Vehicle() {
    }

    Vehicle(int lifetime) {
        try {
            dateExpired = datePurchased.plusYears(lifetime);
        } catch (DateTimeException e) {
            System.out.println("Lifetime period for the vehicle is too long");
            dateExpired = LocalDate.MAX;
        }
    }

    public abstract boolean readyToUse();

    public abstract void performMaintenance();

    public void writeOff() {
        inUse = false;
    }

    public LocalDate getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(LocalDate datePurchased) {
        this.datePurchased = datePurchased;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public boolean getInUse() {
        return inUse;
    }
}
