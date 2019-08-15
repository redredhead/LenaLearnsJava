package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public class PassengerPlane extends Airplane implements Upgradable {
    private transient int qtyFlightAttendants;
    private transient int seatsBusinessClass;
    private transient int seatsEconomyClass;

    public PassengerPlane(AirplaneBuilder plane, int qtyFlightAttendants, int seatsBusinessClass, int seatsEconomyClass) {
        super(plane);
        this.qtyFlightAttendants = qtyFlightAttendants;
        this.seatsBusinessClass = seatsBusinessClass;
        this.seatsEconomyClass = seatsEconomyClass;
    }

    @Override
    public void upgradeEngine() {
        this.getAirEngine().enginePower++;
        this.getAirEngine().engineThrust++;
    }

    @Override
    public void upgradeCabin() {
        seatsBusinessClass += 5;
        seatsEconomyClass += 10;
    }

    @Override
    public void printPlaneInfo() {
        super.printPlaneInfo();
        System.out.println("Seats business: " + getSeatsBusinessClass() + "\nSeats economy: " + getSeatsEconomyClass());
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

