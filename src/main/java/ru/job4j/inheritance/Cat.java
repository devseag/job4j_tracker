package ru.job4j.inheritance;

public class Cat extends Animal {
    @Override
    public void instanceInvoke() {
        System.out.println("Run method Cat instance");
    }

    public static void staticInvoke() {
        System.out.println("Run static method Cat");
    }

    public boolean canPurr() {
        return true;
    }
}
