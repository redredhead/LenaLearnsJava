package com.epam.elena_paveleva.java.lesson1.task2.organization;

import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Airplane;
import com.epam.elena_paveleva.java.lesson1.task2.vehicle.PassengerPlane;

import java.util.Arrays;
import java.util.Comparator;

public class Airline extends Company {

    private Airplane[] fleet = new Airplane[10];

    public Airline(String TIN, String name, String address) {
        super(TIN, name, address);
    }


    public void addPlane(Airplane airplane) {
        for (int i = 0; i < fleet.length; i++) {
            if (fleet[i] == null) {
                fleet[i] = airplane;
                break;
            }
            System.out.println("No space for another plane");
        }
    }

    public void printFleet() {
        int i = 0;
        while (fleet[i] != null) {
            fleet[i].printPlaneInfo();
            System.out.println("");
            i++;
        }
    }

    public int getTotalPayload() {
        int totalPayload = 0;
        int i = 0;
        while (fleet[i] != null) {
            totalPayload += fleet[i].getMaxPayload();
            i++;
        }
        return totalPayload;
    }

    public int getTotalPeopleCapacity() {
        int totalPeopleCapacity = 0;
        int i = 0;
        while (fleet[i] != null) {
            if (fleet[i] instanceof PassengerPlane) {
                totalPeopleCapacity += (((PassengerPlane) fleet[i]).getSeatsBusinessClass() + ((PassengerPlane) fleet[i]).getSeatsEconomyClass());
            }
            i++;
        }
        return totalPeopleCapacity;
    }

    public Airplane findPlane(int distance, int weight) {
        Airplane optimalPlane = null;
        int i = 0;

        while (fleet[i] != null) {
            if (fleet[i].getMaxDistance() >= distance &&
                    fleet[i].getMaxPayload() >= weight) {
                if (optimalPlane != null && fleet[i].getFuelConsumption() < optimalPlane.getFuelConsumption()) {
                    optimalPlane = fleet[i];
                } else {
                    optimalPlane = fleet[i];
                }
            }

            i++;
        }

        if (optimalPlane == null) {
            System.out.println("no plane found");
        }

        return optimalPlane;
    }

    public void sortPlanesByDistance() {
        Comparator<Airplane> distanceComparator = new Comparator<Airplane>() {

            @Override
            public int compare(Airplane o1, Airplane o2) {
                if (o1 == null || o2 == null) {
                    return 0;
                }

                return o1.getMaxDistance() - o2.getMaxDistance();
            }
        };

        Arrays.sort(fleet, distanceComparator);
    }


}
