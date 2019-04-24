package com.epam.elena_paveleva.java.lesson1.task2.organization;

import com.epam.elena_paveleva.java.lesson1.task2.vehicle.Airplane;

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


}
