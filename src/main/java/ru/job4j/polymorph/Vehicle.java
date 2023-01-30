package ru.job4j.polymorph;

public interface Vehicle extends Fuel {
    int WHEELS = 4;

    void changeGear();

    void accelerate();

    void steer();

    void brake();

    static void getDragCoefficient() {
        System.out.println("Formula rascheta kojefficienta ajerodinamicheskogo soprotivlenija avtomobilja");
    }

    default void chargeBattery() {
        System.out.println("Akkumuljator pod kapotom. Zarjadit'.");
    }
}