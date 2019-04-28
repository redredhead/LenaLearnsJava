package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

import java.time.DateTimeException;
import java.time.LocalDate;

public abstract class Vehicle {
    protected int lifetime; //years
    LocalDate dateExpired;
    private LocalDate datePurchased;
    private boolean inUse;

    {
        datePurchased = LocalDate.now();
        inUse = true;
    }

    Vehicle(int lifetime) {
        try {
            dateExpired = datePurchased.plusYears(lifetime);
        } catch (DateTimeException e) {
            System.out.println("Lifetime period for the vehicle is too long");
            dateExpired = LocalDate.MAX;
        }
    }

    public abstract boolean isReadyToUse();

    public abstract void performMaintenance();

    public void writeOff() { //списать
        inUse = false;
    }

    public LocalDate getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(LocalDate datePurchased) {
        this.datePurchased = datePurchased;
    }

    public boolean getInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
