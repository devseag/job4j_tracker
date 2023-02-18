package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CutClone {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Stepan");
        names.add("Petrucho");
        names.add("Ivan");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println(
                List.of(1, 1, 2, 2).stream().collect(
                        Collectors.toMap(
                                e -> e,
                                e -> e * e,
                                (existing, replacement) -> existing
                        ))
        );

    }
}