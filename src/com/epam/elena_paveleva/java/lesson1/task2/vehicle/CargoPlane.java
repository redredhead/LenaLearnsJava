package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public class CargoPlane extends Airplane implements Upgradable {
    transient private int volume;

    private CargoPlane(AirplaneBuilder plane, int volume) {
        super(plane);
        this.volume = volume;
    }

    public static CargoPlaneBuilder getBuilder() {
        return new CargoPlaneBuilder();
    }

    @Override
    public void upgradeEngine() {
        getAirEngine().enginePower++;
    }

    @Override
    public void upgradeCabin() {
        volume += 5;
    }

    @Override
    public void printPlaneInfo() {
        super.printPlaneInfo();
        System.out.println("Plane volume: " + volume);
    }

    public static class CargoPlaneBuilder extends AirplaneBuilder {
        transient int volume;

        public CargoPlaneBuilder setVolume(int volume) {
            this.volume = volume;
            return this;
        }

        public CargoPlane buildPlane() {
            return new CargoPlane(this, volume);
        }
    }


}
