package ru.job4j.polymorph;

public class SportCar implements Vehicle {

    @Override
    public void changeGear() {
        System.out.println("Mehanicheskaja korobka peredach. Vkljuchit' pervuju, dal'she perekljuchat' do shestoj");
    }

    @Override
    public void accelerate() {
        System.out.println("Jelektronnaja pedal' gaza");
    }

    @Override
    public void steer() {
        System.out.println("Ukorochennaja rulevaja rejka dlja uskorennogo povorota rulja");
    }

    @Override
    public void brake() {
        System.out.println("Usilennaja tormoznaja sistema");
    }

    @Override
    public void refill() {
        System.out.println("Zapravit' 100l benzina");
    }

    @Override
    public void chargeBattery() {
        System.out.println("Akkumuljator v bagazhnike. Zarjadit'.");
    }
}