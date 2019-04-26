package com.epam.elena_paveleva.java.lesson1.task2.client;

import com.epam.elena_paveleva.java.lesson1.task2.organization.Airline;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.*;


public class Main {
    public static void main(String[] args) {
        Airline s7 = new Airline("1123332", "S7 Airlines", "St P, Nevsky 23");
        Airplane airplane1 = new PassengerPlane(Airplane.getBuilder()
                .setBasics(20, 15000, 500, 1200)
                .setPlaneFeatures(5, 150, 2, Manufacturer.AIRBUS)
                .setEngine("AMW-113", 120, 150, Manufacturer.BOEING)
                , 5, 20, 150);
        Airplane airplane2 = ((CargoPlane.CargoPlaneBuilder) (CargoPlane.getBuilder()
                .setBasics(20, 7500, 7592, 750)
                .setPlaneFeatures(5, 120, 2, Manufacturer.AIRBUS)
                .setEngine("Eng-111", 10, 2, Manufacturer.ROLLSROYCE)))
                .setVolume(650).buildPlane();
        s7.addPlane(airplane1);
        s7.addPlane(airplane2);
        s7.printFleet();
        System.out.println("total payload:" + s7.getTotalPayload());
        System.out.println("total capacity: " + s7.getTotalPeopleCapacity());
        s7.sortPlanesByDistance();
        s7.printFleet();
        Upgradable.printPlaneManufacturer();
    }
}
