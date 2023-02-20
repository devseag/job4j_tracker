package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Odin", "Dva", "Tri", "Chetyre", "Pjat'");
        boolean rsl = strings
                .stream()
                .noneMatch("Shest'"::contains);
        System.out.println(rsl);
        rsl = strings
                .stream()
                .anyMatch(e -> e.endsWith("a"));
        System.out.println(rsl);
        rsl = strings
                .stream()
                .anyMatch(e -> e.endsWith("Tri"));
        System.out.println(rsl);
    }
}