package com.epam.elena_paveleva.java.lesson1.task2;

import java.time.LocalDate;

public class FlyingVehicle extends Vehicle {

    private int maxSpeed;
    private int maxDistance;
    private int maxPayload;

    {
        maxSpeed = 0;
        maxDistance = 0;
        maxPayload = 0;
    }

    FlyingVehicle() {
    }

    FlyingVehicle(int lifetime, int maxSpeed, int maxDistance, int maxPayload) {
        super(lifetime);
        this.maxSpeed = maxSpeed;
        this.maxDistance = maxDistance;
        this.maxPayload = maxPayload;
    }

    class Engine {
        int weight;
        int length;
        int width;
        int height;
        String model;
    }


    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
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

    @Override
    public boolean readyToUse() {
        return (getInUse() && (dateExpired.isAfter(LocalDate.now())));
    }

    @Override
    public void performMaintenance() {
        dateExpired = dateExpired.plusYears(1);
    }
}
