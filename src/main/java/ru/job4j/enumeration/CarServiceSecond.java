package ru.job4j.enumeration;

public class CarServiceSecond {

    private enum Status {
        ACCEPTED,
        INWORK,
        WAITING,
        FINISHED
    }

    public static void main(String[] args) {
        System.out.println(Status.FINISHED);
    }

}