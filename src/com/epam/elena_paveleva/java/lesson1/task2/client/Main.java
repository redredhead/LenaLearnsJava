package com.epam.elena_paveleva.java.lesson1.task2.client;

import com.epam.elena_paveleva.java.lesson1.task2.organization.Airline;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Airplane;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Manufacturer;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.PassengerPlane;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        Airline s7 = new Airline("1123332", "S7 Airlines", "St P, Nevsky 23");
        Airplane airplane1 = new PassengerPlane(Airplane.getBuilder()
                .setBasics(20, 15000, 500, 1200)
                .setPlaneFeatures(5, 150, 2, Manufacturer.AIRBUS)
                .setEngine("AMW-113", 120, 150, Manufacturer.BOEING)
                , 5, 20, 150);

        /* Airplane airplane2 = ((CargoPlane.CargoPlaneBuilder) (CargoPlane.getBuilder()
                .setBasics(20, 7500, 7592, 750)
                .setPlaneFeatures(5, 120, 2, Manufacturer.AIRBUS)
                .setEngine("Eng-111", 10, 2, Manufacturer.ROLLSROYCE)))
                .setVolume(650).buildPlane();
        Airplane airplane3 = ((CargoPlane.CargoPlaneBuilder) (CargoPlane.getBuilder()
                .setBasics(10, 5000, 6500, 650)
                .setPlaneFeatures(5, 120, 2, Manufacturer.AIRBUS)
                .setEngine("Eng-121", 12, 3, Manufacturer.CONTINENTAL)))
                .setVolume(430).buildPlane();

         s7.addPlane(airplane1);
        s7.addPlane(airplane2);
        s7.addPlane(null); // exception
        s7.addPlane(airplane1); // exception
        airplane2.performMaintenance(null); // exception
        System.out.println("total payload:" + s7.getTotalPayload());
        System.out.println("total capacity: " + s7.getTotalPeopleCapacity());

        try {
            s7.findPlane(7600, 550).printPlaneInfo(); //exception
        } catch (ObjectNotFoundException e) {
            e.printMessage();
        }

        try {
            s7.close();
            s7.close(); //exception
        } catch (IllegalCompanyStateException e) {
            System.out.println("Company already closed");
        }

        s7.addPlane(airplane3); //exception

        try {
            s7.findPlane(100, 50).writeOff();
        } catch (ObjectNotFoundException e) {
            e.printMessage();
        } */

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("filename"))) {
            objectOutputStream.writeObject(s7);
            objectOutputStream.writeObject(airplane1);
        } catch (IOException e) {
            System.out.println("Exception occurred during serialization");
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("filename"))) {
            Airline siberia = (Airline) objectInputStream.readObject();
            Airplane deserializedPlane = (Airplane) objectInputStream.readObject();
            siberia.setName("Авиакомпания \"Сибирь\"");
            siberia.addPlane(deserializedPlane);
            System.out.println("Deserialized company info:");
            siberia.printCompanyInfo();
            siberia.printFleet();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred during deserialization");
            e.printStackTrace();
        }
    }
}

