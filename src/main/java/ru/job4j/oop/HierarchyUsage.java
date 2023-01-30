package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        /* sozdaem ob#ekta klassa Car. */
        Car car = new Car();
        /* delaem privedenie k tipu roditelja Transport. */
        Transport tp = car;
        /* delaem privedenie k tipu roditelja Object. */
        Object obj = car;
        /* Privedenie tipa pri sozdanii ob#ekta. */
        Object ocar = new Car();
        /* Privedenie tipa za schet ponizhenija po ierarhii. */
        Car carFromObject = (Car) ocar;

        /* Oshibka v privedenii tipa. */
 //       Object bicycle = new Bicycle();
 //       Car cb = (Car) bicycle; // kod zavershitsja s oshibkoj privedenija tipov ClassCastException

        System.out.println(new Car());
        System.out.println(new Bicycle());
        System.out.println(new Object());
    }
}