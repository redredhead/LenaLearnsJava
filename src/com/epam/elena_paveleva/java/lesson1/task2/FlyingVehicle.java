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
    private int overallFlight;
    private Engine engine;

    {
        maxSpeed = 0;
        maxDistance = 0;
        maxPayload = 0;
        overallFlight = 0;
    }

    FlyingVehicle() {
    }

    FlyingVehicle(int lifetime, int maxSpeed, int maxDistance, int maxPayload, String engineModel, int enginePower) {
        super(lifetime);
        this.maxSpeed = maxSpeed;
        this.maxDistance = maxDistance;
        this.maxPayload = maxPayload;
        this.overallFlight = 0;
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
        return (getInUse() && (dateExpired.isAfter(LocalDate.now())) && (overallFlight < maxOverallFlight) && (engine.overallFlight < engine.maxOverallFlightHours));
    }

    @Override
    public void performMaintenance() {
        dateExpired = dateExpired.plusYears(1);
    }

    public void replaceEngine(String model, int power) {
        this.engine.model = model;
        this.engine.power = power;
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

    public int getOverallFlight() {
        return overallFlight;
    }

    public void setOverallFlight(int overallFlight) {
        this.overallFlight = overallFlight;
    }

    protected class Engine {

        int overallFlight;
        String model;
        int power;

        private int maxOverallFlightHours = 50000;

        Engine(String model, int power) {
            this.model = model;
            this.power = power;
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
