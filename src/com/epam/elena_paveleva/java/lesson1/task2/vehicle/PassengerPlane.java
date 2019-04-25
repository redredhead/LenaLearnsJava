package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public class PassengerPlane extends Airplane {
    private int qtyFlightAttendants;

    private int seatsBusinessClass;
    private int seatsEconomyClass;
    public PassengerPlane(int lifetime, int maxSpeed, int maxDistance, int maxPayload, int cabinCrew, int fuelConsumption, int fuelCapacity, String engineModel, int enginePower, int engineThrust, Manufacturer planeManufacturer, Manufacturer engineManufacturer,int qtyFlightAttendants, int seatsBusinessClass, int seatsEconomyClass) {
        super(lifetime, maxSpeed, maxDistance, maxPayload, cabinCrew, fuelConsumption, fuelCapacity, engineModel, enginePower, engineThrust, planeManufacturer, engineManufacturer);
        this.qtyFlightAttendants = qtyFlightAttendants;
        this.seatsBusinessClass = seatsBusinessClass;
        this.seatsEconomyClass = seatsEconomyClass;
    }

    public int getQtyFlightAttendants() {
        return qtyFlightAttendants;
    }

    public void setQtyFlightAttendants(int qtyFlightAttendants) {
        this.qtyFlightAttendants = qtyFlightAttendants;
    }

    public int getSeatsBusinessClass() {
        return seatsBusinessClass;
    }

    public void setSeatsBusinessClass(int seatsBusinessClass) {
        this.seatsBusinessClass = seatsBusinessClass;
    }

    public int getSeatsEconomyClass() {
        return seatsEconomyClass;
    }

    public void setSeatsEconomyClass(int seatsEconomyClass) {
        this.seatsEconomyClass = seatsEconomyClass;
    }
}

