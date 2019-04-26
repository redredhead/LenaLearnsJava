package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public interface Upgradable {
    static void printPlaneManufacturer() {
        System.out.println("List of plane manufacturers: ");
        for (Manufacturer m : Manufacturer.values()) {
            if (m.isUsedInPlanes()) {
                System.out.println(m.toString());
            }
        }
    }

    void upgradeEngine();

    void upgradeCabin();
}
