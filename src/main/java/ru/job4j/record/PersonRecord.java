package ru.job4j.record;

//public record PersonRecord(String name, int age) { }

//public record PersonRecord(String name, int age) {
//    public static int maxAge = 100;
//
//    public static int getMaxAge() {
//        return maxAge;
//    }
//
//    public void info() {
//        System.out.println("Print Info");
//    }
//
//    @Override
//    public String toString() {
//        return "Person{"
//                + "name='" + name + '\''
//                + ", age=" + age
//                + '}';
//    }
//
//}

//public record PersonRecord(String name, int age) implements Comparable<PersonRecord> {
//    @Override
//    public int compareTo(PersonRecord o) {
//        return name.compareTo(o.name);
//    }
//}

public record PersonRecord(String name, int age) {
    public PersonRecord {
        if (age > 101) {
            throw new IllegalArgumentException("Age cannot be more than 101");
        }
    }
}