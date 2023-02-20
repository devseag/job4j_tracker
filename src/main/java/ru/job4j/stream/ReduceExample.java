package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numsI = List.of(1, 2, 3, 4);
        Optional<Integer> sumI = numsI.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sumI.get());

        List<String> numStr = List.of("One", "Two", "Three");
        Optional<String> sumStr = numStr.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println(sumStr.get());

        List<Integer> numsIden = Arrays.asList(1, 2, 3, 4);
        int sumIden = numsIden.stream()
                .reduce(2, (a, b) -> a + b);
        System.out.println(sumIden);

        List<Person> people = Arrays.asList(
                new Person("Mihail", 35),
                new Person("Ol'ga", 26),
                new Person("Anton", 20),
                new Person("Viktor", 16),
                new Person("Anna", 29)
        );
        int sum = people.stream()
                .reduce(
                        0,
                        (a, b) -> {
                            if (b.getAge() > 25) {
                                return a + b.getAge();
                            } else {
                                return a;
                            }
                        },
                        (a, b) -> a + b
                );
        System.out.println(sum);

        int min = people.parallelStream()
                .reduce(
                        0,
                        (a, b) -> a + b.getAge(),
                        Integer::min
                );
        System.out.println(min);
    }
}