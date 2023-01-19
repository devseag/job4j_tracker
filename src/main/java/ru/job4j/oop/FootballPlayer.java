package ru.job4j.oop;

public class FootballPlayer extends Sportsman {

    @Override
    void run() {
        System.out.println("Median velocity for run");
    }

    public void footKick() {
        System.out.println("Kick the ball");
    }

}