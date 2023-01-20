package ru.job4j.oop;

public class Local {
    private String name = "Name";

    public void getFullName() {
        final String surname = "Surname";

        class FullName {
            public static final String PATRONYMIC = "Empty";

            public void printFullName() {
                System.out.println(name + " " + surname);
            }

        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }

    public static void main(String[] args) {
        Local local = new Local();
        local.getFullName();
    }

}