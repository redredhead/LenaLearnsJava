package com.epam.elena_paveleva.java.lesson1.task2;

public class Airplane extends FlyingVehicle{
    private int cabinCrew;
    private int fuelCapacity;
    private int fuelLvl;

    Airplane (int lifetime, int maxSpeed, int maxDistance, int maxPayload, int cabinCrew, int fuelCapacity) {
        super(lifetime, maxSpeed, maxDistance, maxPayload);
        this.cabinCrew = cabinCrew;
        this.fuelCapacity = fuelCapacity;
    }

    class AirEngine extends Engine {
        int thrust;

        AirEngine(int weight, int length, int width, int height, String model, int thrust) {
            super(weight, length, width, height, model);
            this.thrust = thrust;
        }
    }
}
