package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        HashSet<String> autos = new HashSet<>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Ivan");
        names.add("Vasily");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        autos.add("Tesla");
        for (String name : names) {
            System.out.println(name);
        }
        for (String as: autos) {
            System.out.println(as);
        }
    }
}