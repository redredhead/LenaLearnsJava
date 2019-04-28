package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public class Airplane extends FlyingVehicle {
    private static int boardCounter = 0;
    final private int boardNumber;
    private int cabinCrew;
    private int fuelConsumption;
    private int fuelCapacity;
    private int fuelLvl;
    private AirEngine airEngine;

    {
        System.out.println("New plane created with board number: " + ++boardCounter);
    }

    private Manufacturer manufacturer;

    Airplane(AirplaneBuilder plane) {
        super(plane.lifetime, plane.maxSpeed, plane.maxDistance, plane.maxPayload);
        this.cabinCrew = plane.cabinCrew;
        this.fuelConsumption = plane.fuelConsumption;
        this.fuelCapacity = plane.fuelCapacity;

        if (plane.planeManufacturer.isUsedInPlanes()) {
            this.manufacturer = plane.planeManufacturer;
        } else {
            this.manufacturer = Manufacturer.NA;
            System.out.println("Brand " + plane.planeManufacturer + " does not make planes");
        }

        this.airEngine = new AirEngine(plane.engineSerialnum, plane.enginePower, plane.engineThrust, plane.engineManufacturer);
        boardNumber = boardCounter;
    }


    public static AirplaneBuilder getBuilder() {
        return new AirplaneBuilder();
    }

    public void replaceEngine(String engineSerialNum, int enginePower, int engineThrust, Manufacturer engineManufacturer) {
        this.airEngine = new AirEngine(engineSerialNum, enginePower, engineThrust, engineManufacturer);
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
                getMaxDistance() + "\nMax payload: " + getMaxPayload() + "\nFuel Consumption: " + fuelConsumption);
    }

    public int getBoardNumber() {
        return boardNumber;
    }

    public AirEngine getAirEngine() {
        return airEngine;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public static class AirplaneBuilder {

        private int lifetime;
        private int maxDistance;
        private int maxPayload;
        private int maxSpeed;
        private int fuelConsumption;
        private int fuelCapacity;
        private int cabinCrew;
        private Manufacturer planeManufacturer;
        private String engineSerialnum;
        private int engineThrust;
        private Manufacturer engineManufacturer;
        private int enginePower;

        public AirplaneBuilder setBasics(int lifetime, int maxDistance, int maxPayload, int maxSpeed) {
            this.lifetime = lifetime;
            this.maxDistance = maxDistance;
            this.maxPayload = maxPayload;
            this.maxSpeed = maxSpeed;
            return this;
        }

        public AirplaneBuilder setPlaneFeatures(int fuelConsumption, int fuelCapacity, int cabinCrew, Manufacturer planeManufacturer) {
            this.fuelCapacity = fuelCapacity;
            this.fuelConsumption = fuelConsumption;
            this.cabinCrew = cabinCrew;
            this.planeManufacturer = planeManufacturer;
            return this;
        }

        public AirplaneBuilder setEngine(String engineSerialNum, int engineThrust, int enginePower, Manufacturer engineManufacturer) {
            this.engineSerialnum = engineSerialNum;
            this.engineThrust = engineThrust;
            this.enginePower = enginePower;
            this.engineManufacturer = engineManufacturer;
            return this;
        }

        public Airplane buildPlane() {
            return new Airplane(this);
        }
    }

    protected class AirEngine extends Engine {


        int engineThrust;
        Manufacturer manufacturer;

        AirEngine(String engineSerialNum, int enginePower, int engineThrust, Manufacturer manufacturer) {
            super(engineSerialNum, enginePower);
            this.engineThrust = engineThrust;
            if (manufacturer.isUsedInAirEngines()) {
                this.manufacturer = manufacturer;
            } else {
                this.manufacturer = Manufacturer.NA;
                System.out.println("Brand does not make air engines: " + manufacturer);
            }
        }

    }
}
