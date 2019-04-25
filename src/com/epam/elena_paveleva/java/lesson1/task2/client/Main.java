package com.epam.elena_paveleva.java.lesson1.task2.client;

import com.epam.elena_paveleva.java.lesson1.task2.organization.Airline;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Airplane;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.CargoPlane;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Manufacturer;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.PassengerPlane;


public class Main {
    public static void main(String[] args) {
        Airline s7 = new Airline("1123332", "S7 Airlines", "St P, Nevsky 23");
        Airplane airplane1 = new PassengerPlane(20, 950, 10000, 500, 2,
                5, 150, "Eng-113", 10, 2, Manufacturer.AIRBUS, Manufacturer.BOEING,
                3,20,100);
        Airplane airplane2 = new CargoPlane(20, 700, 7500, 250, 2, 3, 120,
                "Eng-111", 10, 2, Manufacturer.AIRBUS, Manufacturer.ROLLSROYCE,600);
        s7.addPlane(airplane1);
        s7.addPlane(airplane2);
        s7.printFleet();
        System.out.println("total payload:" + s7.getTotalPayload());
        System.out.println("total capacity: " + s7.getTotalPeopleCapacity());
        s7.sortPlanesByDistance();
        s7.printFleet();
    }
}
