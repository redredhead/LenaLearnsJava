package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public enum Manufacturer {
    AIRBUS(true, false),
    BOEING(true, true),
    BOMBARDIER(true, false),
    CONTINENTAL(false, true),
    EMBRAER(true, false),
    ROLLSROYCE(false, true),
    NA(true, true);

    private boolean usedInPlanes;
    private boolean usedInAirEngines;

    Manufacturer(boolean usedInPlanes, boolean usedInAirEngines) {
        this.usedInPlanes = usedInPlanes;
        this.usedInAirEngines = usedInAirEngines;
    }

    public boolean isUsedInPlanes() {
        return usedInPlanes;
    }

    public boolean isUsedInAirEngines() {
        return usedInAirEngines;
    }

}
