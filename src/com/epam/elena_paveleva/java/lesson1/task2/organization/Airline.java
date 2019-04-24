package com.epam.elena_paveleva.java.lesson1.task2.organization;

import com.epam.elena_paveleva.java.lesson1.task2.vehicle.FlyingVehicle;

public class Airline extends Company {

    FlyingVehicle[] fleet = new FlyingVehicle[10];

    Airline(String TIN, String name, String address) {
        super(TIN, name, address);
    }
}
