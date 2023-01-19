package ru.job4j.oop;

public class Truck extends Vehicle {

    @Override
    public void accelerate() {
        System.out.println("Electrical accelerate");
    }

    @Override
    public void steer() {
        System.out.println("Standard steer control");
    }

}