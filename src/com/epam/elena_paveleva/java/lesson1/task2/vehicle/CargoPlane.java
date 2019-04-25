package com.epam.elena_paveleva.java.lesson1.task2.vehicle;

public class CargoPlane extends Airplane {
    private int volume;

    private CargoPlane(AirplaneBuilder plane, int volume) {
        super(plane);
        this.volume = volume;
    }

    public static CargoPlaneBuilder getBuilder() {
        CargoPlaneBuilder builder = new CargoPlaneBuilder();
        return builder;
    }

    public static class CargoPlaneBuilder extends AirplaneBuilder {
        int volume;

        public CargoPlaneBuilder setVolume(int volume) {
            this.volume = volume;
            return this;
        }

        public CargoPlane buildPlane() {
            CargoPlane plane = new CargoPlane(this, volume);
            return plane;
        }
    }


}
