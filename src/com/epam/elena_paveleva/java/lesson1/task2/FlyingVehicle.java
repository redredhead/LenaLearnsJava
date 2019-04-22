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

    {
        maxSpeed = 0;
        maxDistance = 0;
        maxPayload = 0;
        overallFlight = 0;
    }

    FlyingVehicle() {
    }

    FlyingVehicle(int lifetime, int maxSpeed, int maxDistance, int maxPayload) {
        super(lifetime);
        this.maxSpeed = maxSpeed;
        this.maxDistance = maxDistance;
        this.maxPayload = maxPayload;
        this.overallFlight = 0;
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
        return (getInUse() && (dateExpired.isAfter(LocalDate.now())) && (overallFlight < maxOverallFlight));
    }

    @Override
    public void performMaintenance() {
        dateExpired = dateExpired.plusYears(1);
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

        int weight;
        int length;
        int width;
        int height;
        int overallFlight;
        String model;
        private int maxOverallFlightHours;

        Engine(int weight, int length, int width, int height, String model) {
            this.weight = weight;
            this.width = width;
            this.length = length;
            this.height = height;
            this.model = model;
            this.overallFlight = 0;
        }


    }
}
