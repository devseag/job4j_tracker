package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void ride() {
        System.out.println("Riding");
    }

    @Override
    public void passengers(int num) {
        System.out.println("Number of passengers: " + num);
    }

    @Override
    public double refuel(int amount) {
        return 10.5 * amount;
    }
}
