package com.epam.elena_paveleva.java.lesson1.task2;

import java.time.LocalDate;

public class FlyingVehicle extends Vehicle {


    private static int maxOverallFlight;

    static {
        maxOverallFlight = 50000;
    }

    private int maxSpeed;
    private int maxDistance;
    private int maxPayload;
    private int mileage;
    private Engine engine;

    {
        maxSpeed = 0;
        maxDistance = 0;
        maxPayload = 0;
        mileage = 0;
    }

    FlyingVehicle() {
    }

    protected FlyingVehicle(int lifetime, int maxSpeed, int maxDistance, int maxPayload) {
        super(lifetime);
        this.maxSpeed = maxSpeed;
        this.maxDistance = maxDistance;
        this.maxPayload = maxPayload;
        this.mileage = 0;
    }

    FlyingVehicle(int lifetime, int maxSpeed, int maxDistance, int maxPayload, String engineModel, int enginePower) {
        this(lifetime, maxSpeed, maxDistance, maxPayload);
        engine = new Engine(engineModel, enginePower);
    }

    public static int getMaxOverallFlight() {
        return maxOverallFlight;
    }

    public static void setMaxOverallFlight(int maxOverallFlight) {
        FlyingVehicle.maxOverallFlight = maxOverallFlight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean isReadyToUse() {
        return (getInUse() && (dateExpired.isAfter(LocalDate.now())) && (mileage < maxOverallFlight) && (engine.overallFlight < engine.maxOverallFlightHours));
    }

    @Override
    public void performMaintenance() {
        dateExpired = dateExpired.plusYears(1);
    }

    public void replaceEngine(String engineModel, int enginePower) {
        this.engine.engineModel = engineModel;
        this.engine.enginePower = enginePower;
        this.engine.overallFlight = 0;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    protected class Engine {

        int overallFlight;
        String engineModel;
        int enginePower;

        private int maxOverallFlightHours = 50000;

        Engine(String engineModel, int enginePower) {
            this.engineModel = engineModel;
            this.enginePower = enginePower;
            this.overallFlight = 0;
        }

        public int getMaxOverallFlightHours() {
            return maxOverallFlightHours;
        }

        public void setMaxOverallFlightHours(int maxOverallFlightHours) {
            this.maxOverallFlightHours = maxOverallFlightHours;
        }
    }
}
