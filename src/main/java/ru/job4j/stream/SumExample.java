package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.*;

public class SumExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Mihail", 35),
                new Person("Ol'ga", 26),
                new Person("Anton", 20),
                new Person("Viktor", 16),
                new Person("Anna", 29)
        );
        int sum = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sum);
    }
}