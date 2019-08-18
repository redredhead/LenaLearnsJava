package com.epam.elena_paveleva.java.lesson1.task2.client;

import com.epam.elena_paveleva.java.lesson1.task2.exceptions.SerializationException;
import com.epam.elena_paveleva.java.lesson1.task2.organization.Airline;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Airplane;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Manufacturer;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.PassengerPlane;
import com.epam.elena_paveleva.java.lesson5.serialization.SerializationHelper;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {
        Airline s7 = new Airline("1123332", "S7 Airlines", "St P, Nevsky 23");
        Airplane airplane1 = new PassengerPlane(Airplane.getBuilder()
                .setBasics(20, 15000, 500, 1200)
                .setPlaneFeatures(5, 150, 2, Manufacturer.AIRBUS)
                .setEngine("AMW-113", 120, 150, Manufacturer.BOEING)
                , 5, 20, 150);

        try {
            //serialize
            Path f1 = SerializationHelper.serialize(s7, "f1");
            Path f2 = SerializationHelper.serialize(airplane1, "f2");

            //deserialize
            Airline siberia = SerializationHelper.deserialize(f1);
            Airplane deserializedPlane = SerializationHelper.deserialize(f2);

            //edit and print
            siberia.setName("Авиакомпания \"Сибирь\"");
            siberia.addPlane(deserializedPlane);
            System.out.println("Deserialized company info:");
            siberia.printCompanyInfo();
            siberia.printFleet();
        } catch (FileAlreadyExistsException | SerializationException e) {
            e.printStackTrace();
        }
    }
}

