package com.epam.elena_paveleva.java.lesson1.task2.client;

import com.epam.elena_paveleva.java.lesson1.task2.organization.Airline;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Airplane;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Manufacturer;


public class Main {
    public static void main(String[] args) {
        Airline s7 = new Airline("1123332", "S7 Airlines", "St P, Nevsky 23");
        Airplane airplane1 = new Airplane(20, 950, 10000, 500, 2, 5, 150, "Eng-113", 10, 2, Manufacturer.AIRBUS, Manufacturer.BOEING);
        Airplane airplane2 = new Airplane(20, 700, 7500, 250, 2, 3, 120, "Eng-111", 10, 2, Manufacturer.AIRBUS, Manufacturer.ROLLSROYCE);
        s7.addPlane(airplane1);
        s7.addPlane(airplane2);
        s7.printFleet();
        System.out.println("total payload:" + s7.getTotalPayload());
    }
}
