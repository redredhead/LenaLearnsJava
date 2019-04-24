package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public class Airplane extends FlyingVehicle {
    private static int boardCounter = 0;
    final private int boardNumber;
    private int cabinCrew;
    private int fuelConsumption;
    private int fuelCapacity;
    private int fuelLvl;
    private AirEngine airEngine;
    private Manufacturer manufacturer;

    public Airplane(int lifetime, int maxSpeed, int maxDistance, int maxPayload, int cabinCrew, int fuelConsumption, int fuelCapacity, String engineSerialNum, int enginePower, int engineThrust, Manufacturer planeManufacturer, Manufacturer engineManufacturer) {
        super(lifetime, maxSpeed, maxDistance, maxPayload);
        boardNumber = ++boardCounter;
        this.cabinCrew = cabinCrew;
        this.fuelConsumption = fuelConsumption;
        this.fuelCapacity = fuelCapacity;
        this.fuelLvl = fuelCapacity;
        this.airEngine = new AirEngine(engineSerialNum, enginePower, engineThrust, engineManufacturer);

        if (planeManufacturer.isUsedInPlanes()) {
            this.manufacturer = planeManufacturer;
        } else {
            this.manufacturer = Manufacturer.NA;
            System.out.println("This brand does not make planes");
        }

        System.out.println("New plane created with board number: " + boardNumber);
    }

    public void replaceEngine(String engineSerialNum, int enginePower, int engineThrust, Manufacturer engineManifacturer) {
        this.airEngine = new AirEngine(engineSerialNum, enginePower, engineThrust, engineManifacturer);
    }

    public void tankUp() {
        fuelLvl = fuelCapacity;
    }

    boolean isReadyForFlight(int distance) {
        return ((distance < getMaxDistance()) && (fuelLvl > fuelConsumption * distance));
    }

    public void fly(int distance) {
        if (!isReadyForFlight(distance)) {
            System.out.println("Airplane can't perform this flight. Destination point is too far or fuel lvl is too low");
        } else {
            fuelLvl -= distance * fuelConsumption;
            setMileage(getMileage() + distance);
        }
    }

    public void printPlaneInfo() {
        System.out.println("Board number: " + boardNumber + "\nManufacturer: " + manufacturer + "\nMax distance: " +
                getMaxDistance() + "\nMax payload: " + getMaxPayload());
    }

    public int getBoardNumber() {
        return boardNumber;
    }

    private class AirEngine extends Engine {

        int engineThrust;
        Manufacturer manufacturer;

        AirEngine(String engineSerialNum, int enginePower, int engineThrust, Manufacturer manufacturer) {
            super(engineSerialNum, enginePower);
            this.engineThrust = engineThrust;
            if (manufacturer.isUsedInAirEngines()) {
                this.manufacturer = manufacturer;
            } else {
                this.manufacturer = Manufacturer.NA;
                System.out.println("This brand does not make air engines");
            }
        }

    }


}
