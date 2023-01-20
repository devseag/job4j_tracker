package ru.job4j.oop;

public class BirdMain {

    public static void main(String[] args) {
        Bird bird = new Bird() {
            @Override
            public void fly() {
                System.out.println("Parrot is flying over the road");
            }

            public void flyInside() {
                System.out.println("Parrot is flying only inside anonymous class");
            }
        };
    }

}