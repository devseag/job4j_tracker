package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

//    public Student findByAccount(String account) {
//        for (Student s : students.keySet()) {
//            if (s.account().equals(account)) {
//                return s;
//            }
//        }
//        return null;
//    }

//    public Student findByAccount(String account) {
//        return students.keySet()
//                .stream()
//                .filter(s -> s.account().equals(account))
//                .findFirst()
//                .orElse(null);
//    }

        public Optional<Student> findByAccount(String account) {
        for (Student s : students.keySet()) {
            if (s.account().equals(account)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

//    public Subject findBySubjectName(String account, String name) {
//        Student a = findByAccount(account);
//        if (a != null) {
//            Set<Subject> subjects = students.get(a);
//            for (Subject s : subjects) {
//                if (s.name().equals(name)) {
//                    return s;
//                }
//            }
//        }
//        return null;
//    }

//    public Subject findBySubjectName(String account, String name) {
//        Student a = findByAccount(account);
//        if (a != null) {
//            return students.get(a)
//                    .stream()
//                    .filter(s -> s.name().equals(name))
//                    .findFirst()
//                    .orElse(null);
//        }
//        return null;
//    }

        public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            Set<Subject> subjects = students.get(a.get());
            for (Subject s : subjects) {
                if (s.name().equals(name)) {
                    return Optional.of(s);
                }
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        System.out.println("Najdennyj student: " + student);
        Optional<Subject> english = college.findBySubjectName("000001", "English");
        System.out.println("Ocenka po najdennomu predmetu: " + english.get().score());
    }
}