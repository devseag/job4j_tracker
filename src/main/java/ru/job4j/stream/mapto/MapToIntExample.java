package ru.job4j.stream.mapto;

import java.util.Arrays;
import java.util.List;

public class MapToIntExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Mihail", 35),
                new Person("Ol'ga", 26),
                new Person("Anton", 20),
                new Person("Viktor", 16),
                new Person("Anna", 29)
        );
        int sum = people.stream()
                .filter(e -> e.getAge() > 25)
                .mapToInt(Person::getAge)
                .peek(System.out::println)
                .sum();
        System.out.println("Summa: " + sum);
    }
}