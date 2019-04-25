 package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public class CargoPlane extends Airplane {
    private int volume;

    public CargoPlane(int lifetime, int maxSpeed, int maxDistance, int maxPayload, int cabinCrew, int fuelConsumption, int fuelCapacity, String engineModel, int enginePower, int engineThrust, Manufacturer planeManufacturer, Manufacturer engineManufacturer,int volume) {
        super(lifetime, maxSpeed, maxDistance, maxPayload, cabinCrew, fuelConsumption, fuelCapacity, engineModel, enginePower, engineThrust, planeManufacturer, engineManufacturer);
        this.volume = volume;
    }


}
