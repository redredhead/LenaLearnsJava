package com.epam.elena_paveleva.java.lesson1.task2;

public class Airplane extends FlyingVehicle{
    private int cabinCrew;
    private int fuelConsumption;
    private int fuelCapacity;
    private int fuelLvl;
    private AirEngine airEngine;

    Airplane (int lifetime, int maxSpeed, int maxDistance, int maxPayload, int cabinCrew, int fuelConsumption, int fuelCapacity, String engineModel, int enginePower, int engineThrust) {
        super(lifetime, maxSpeed, maxDistance, maxPayload);
        this.cabinCrew = cabinCrew;
        this.fuelConsumption = fuelConsumption;
        this.fuelCapacity = fuelCapacity;
        this.fuelLvl = fuelCapacity;
        this.airEngine = new AirEngine(engineModel,enginePower,engineThrust);
    }

    private class AirEngine extends Engine {
        int engineThrust;

        AirEngine(String engineModel, int enginePower, int engineThrust) {
            super(engineModel,enginePower);
            this.engineThrust = engineThrust;
        }
    }
    public void replaceEngine(String engineModel, int enginePower, int engineThrust) {
        super.replaceEngine(engineModel,enginePower);
        this.airEngine.engineThrust = engineThrust;
    }

    public void tankUp () {
        fuelLvl = fuelCapacity;
    }

    boolean isReadyForFlight (int distance) {
        return ((distance < getMaxDistance()) && (fuelLvl > fuelConsumption*distance));
    }

    public void fly (int distance) {
        if (!isReadyForFlight(distance)) {
            System.out.println("Airplane can't perform this flight. Destination point is too far or fuel lvl is too low");
        } else {
            fuelLvl-=distance*fuelConsumption;
            setMileage(getMileage()+distance);
        }
    }


}
