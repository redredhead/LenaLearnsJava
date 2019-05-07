package com.epam.elena_paveleva.java.lesson1.task2.organization;

import com.epam.elena_paveleva.java.lesson1.task2.exceptions.IllegalCompanyStateException;
import com.epam.elena_paveleva.java.lesson1.task2.exceptions.ObjectNotFoundException;
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
        try {
            if (isActive()) {
                for (int i = 0; i < fleet.length; i++) {
                    if ((airplane == null) || (airplane != null && fleet[i] == airplane)) {
                        throw new IllegalArgumentException("plane already exists or argument value is null");
                    }
                    if (i == 10 && fleet[i] != null) {
                        System.out.println("No space for another plane");
                    }
                    if (fleet[i] == null) {
                        fleet[i] = airplane;
                        fleet[i].setCompany(this);
                        sortPlanesByDistance();
                        break;
                    }
                }
            } else {
                throw new IllegalCompanyStateException("unable to modify fleet of closed company");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Plane already added or null value passed");
        } catch (IllegalCompanyStateException e) {
            System.out.println("Unable to add new plane to closed airline");
        }
    }


    public void printFleet() {
        int i = 0;
        while (fleet[i] != null) {
            fleet[i].printPlaneInfo();
            System.out.println();
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

    public Airplane findPlane(int distance, int weight) throws ObjectNotFoundException {
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
            throw new ObjectNotFoundException("airplane");
        }

        return optimalPlane;
    }

    private void sortPlanesByDistance() {
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
