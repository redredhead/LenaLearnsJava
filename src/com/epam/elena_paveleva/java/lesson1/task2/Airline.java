package com.epam.elena_paveleva.java.lesson1.task2;

public class Airline extends Company {

    FlyingVehicle[] fleet = new FlyingVehicle[10];

    Airline(String TIN, String name, String address) {
        super(TIN, name, address);
    }
}
