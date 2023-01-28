package ru.job4j.format;

import java.util.Calendar;

public class Format {

    public static void getGreeting(String name, int age) {
        System.out.println(String.format("Hello! I am %s, my age: %d", name, age));
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Hello, %s! Current date: %tF, Current time: %tT", name, instance, instance));
    }

    public static void main(String[] args) {
        getGreeting("Helen", 22);
        System.out.println(String.format("Is Argument? %b", 55));
        System.out.println(String.format("Jo%c4j", 'b'));
        System.out.format("String1%nString2%n");
        getGreetingAndTime("Anna");
        System.out.println(String.format("Float number 0.99 - %f", 0.99));
        System.out.println(String.format("Float number 0.99 - %.2f", 0.99));
        System.out.println(String.format("%1$,+016.2f", 5000000.0000));
    }

}