package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e,
                        (existing, replacement) -> existing
                        ));
    }

//    public List<Student> levelOf(List<Student> students, int bound) {
//        return students.stream()
//                .flatMap(Stream::ofNullable)
//                .sorted()
//                .filter(student -> student.getScore() > bound)
//                .collect(Collectors.toList());
//    }
}