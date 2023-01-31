package ru.job4j.tracker.oop;

public class VehicleUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plain = new Plain();

        Vehicle[] vehicles = new Vehicle[] {bus, train, plain};
        for (Vehicle v: vehicles) {
            v.move();
        }
    }
}
