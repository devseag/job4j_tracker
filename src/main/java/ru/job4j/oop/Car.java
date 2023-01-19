package ru.job4j.oop;

public class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Engine is started");
    }

    public class Transmission {

        public void accelerate() {
            System.out.println("Acceleration");
        }

    }

    public class Brakes {

        public void brake() {
            System.out.println("Braking");
        }

    }

    public class TripComputer {

        public String tripData = "Portal computer";
        private String model = "Serial for TripComputer";

        public void getInfo() {
            System.out.println("Model TripComputer: " + this.model);
            System.out.println("Model Car: " + Car.this.model);
        }

    }



}