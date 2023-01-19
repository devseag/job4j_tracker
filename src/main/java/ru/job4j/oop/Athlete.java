package ru.job4j.oop;

public class Athlete extends Sportsman {

    @Override
    void run() {
        System.out.println("Fast speed for run");
    }

    public void sprint() {
        System.out.println("Fast sprint");
    }

}