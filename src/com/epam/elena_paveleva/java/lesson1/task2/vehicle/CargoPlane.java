package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public class CargoPlane extends Airplane {
    private int volume;

    CargoPlane(int lifetime, int maxSpeed, int maxDistance, int maxPayload, int cabinCrew, int fuelCapacity, int volume) {
        super(lifetime, maxSpeed, maxDistance, maxPayload, cabinCrew, fuelCapacity);
    }


}
