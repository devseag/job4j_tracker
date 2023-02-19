package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Mihail"), new StringBuilder("Ivan"), new StringBuilder("Elena"));
        List<StringBuilder> editedNames = names
                .stream()
                .peek((el) -> el.append(" (Uchenik Job4j)"))
                .sorted()
                .toList();
        System.out.println(editedNames);
    }
}