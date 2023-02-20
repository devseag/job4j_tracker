package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ru.job4j.stream.mapto.Person;

public class MaxExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Mihail", 35),
                new Person("Ol'ga", 26),
                new Person("Anton", 20),
                new Person("Viktor", 16),
                new Person("Anna", 29)
        );
        Optional<Person> youngestPerson = people.stream()
                .max(Comparator.comparing(Person::getAge));
        int age = youngestPerson.get().getAge();
        System.out.println(age);
    }
}