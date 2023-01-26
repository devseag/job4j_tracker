package ru.job4j.pojo;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Paul Hilton");
        student.setGroup("Second");
        student.setDate(new Date());
        System.out.println("Student with FIO: " + student.getFio() + System.lineSeparator()
                + "in the group: " + student.getGroup() + System.lineSeparator()
                + "and submission date: " + student.getDate());
    }
}
