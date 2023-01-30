package ru.job4j.polymorph;

public class TownCar implements Vehicle {

    @Override
    public void changeGear() {
        System.out.println("Korobka peredach avtomat. Postavit' selektor v rezhim D.");
    }

    @Override
    public void accelerate() {
        System.out.println("Nazhatie na pedal' gaza mehanicheski otkryvaet drossel'nuju zaslonku");
    }

    @Override
    public void steer() {
        System.out.println("Standartnoe rulevoe upravlenie");
    }

    @Override
    public void brake() {
        System.out.println("Standartnaja tormoznaja sistema");
    }

    @Override
    public void refill() {
        System.out.println("Zapravit' 60l benzina");
    }

}