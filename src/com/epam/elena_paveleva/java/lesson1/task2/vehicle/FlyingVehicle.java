package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

import java.io.Serializable;
import java.time.LocalDate;

public class FlyingVehicle extends Vehicle {


    transient private static int maxOverallFlight;

    static {
        maxOverallFlight = 50000;
    }

    transient private int maxSpeed;
    transient private int maxDistance;
    transient private int maxPayload;
    transient private int mileage;
    private Engine engine;

    FlyingVehicle(int lifetime, int maxSpeed, int maxDistance, int maxPayload) {
        super(lifetime);
        this.maxSpeed = maxSpeed;
        this.maxDistance = maxDistance;
        this.maxPayload = maxPayload;
        this.mileage = 0;
    }

    FlyingVehicle(int lifetime, int maxSpeed, int maxDistance, int maxPayload, String engineSerialNum, int enginePower) {
        this(lifetime, maxSpeed, maxDistance, maxPayload);
        engine = new Engine(engineSerialNum, enginePower);
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

    public void replaceEngine(String engineSerialNum, int enginePower) {
        this.engine = new Engine(engineSerialNum, enginePower);
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

    protected class Engine implements Serializable {

        final String engineSerialNum;
        transient int overallFlight;
        transient int enginePower;

        private transient int maxOverallFlightHours = 50000;

        Engine(String engineSerialNum, int enginePower) {
            this.engineSerialNum = engineSerialNum;
            this.enginePower = enginePower;
            this.overallFlight = 0;
        }

        public int getMaxOverallFlightHours() {
            return maxOverallFlightHours;
        }

        public void setMaxOverallFlightHours(int maxOverallFlightHours) {
            this.maxOverallFlightHours = maxOverallFlightHours;
        }

        public String getEngineSerialNum() {
            return this.engineSerialNum;
        }
    }
}
